package com.epam.movie.filter;

import com.epam.movie.command.CommandRegistry;
import com.epam.movie.model.Account;
import com.epam.movie.model.Role;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "roleFilter")
public class RoleFilter implements Filter {

    private static final String ERROR_JSP = "WEB-INF/view/error.jsp";

    private static final String ROLE_ATTRIBUTE = "role";
    private static final String ACCOUNT_ATTRIBUTE = "account";
    private static final String COMMAND_PARAMETER = "command";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        if (accessToCommandIsPermitted(request, session)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //((HttpServletResponse) servletRequest).sendRedirect(ERROR_JSP);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(ERROR_JSP);
            dispatcher.forward(servletRequest, servletResponse);
        }
    }

    private boolean accessToCommandIsPermitted(HttpServletRequest request, HttpSession session) {
        String command = request.getParameter(COMMAND_PARAMETER);
        Role currentRole = (Role) session.getAttribute(ROLE_ATTRIBUTE);
        Account account = (Account) session.getAttribute(ACCOUNT_ATTRIBUTE);

        CommandRegistry commandRegistry = CommandRegistry.valueOf(command.toUpperCase());
        List<Role> roles = commandRegistry.getAllowedRoles();

        return userNotAuthorizedAndAccessNotRestricted(account, roles)
                || userAuthorizedAndAccessNotRestricted(currentRole, account, roles);
    }

    private boolean userNotAuthorizedAndAccessNotRestricted(Account account, List<Role> roles) {
        if (account == null) {
            for (Role role : roles) {
                if (role.equals(Role.UNAUTHORIZED)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean userAuthorizedAndAccessNotRestricted(Role currentRole, Account account, List<Role> roles) {
        if (account != null && currentRole != null) {
            for (Role role : roles) {
                if (role.equals(currentRole)) {
                    return true;
                }
            }
        }
        return false;
    }
}