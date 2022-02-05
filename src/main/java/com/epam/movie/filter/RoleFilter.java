package com.epam.movie.filter;

import com.epam.movie.command.CommandRegistry;
import com.epam.movie.model.Role;
import com.epam.movie.model.Status;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = "/controller")
public class RoleFilter implements Filter {

    private static final Map<String, List<Role>> ROLES_BY_COMMANDS = new HashMap<>();

    private static final String ERROR_JSP = "WEB-INF/view/error.jsp";
    private static final String BANNED_JSP = "WEB-INF/view/banned.jsp";
    private static final String LOGIN_JSP = "index.jsp";
    private static final String SIGN_UP_JSP = "WEB-INF/view/signup.jsp";

    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String ROLE_ATTRIBUTE = "role";
    private static final String STATUS_ATTRIBUTE = "status";
    private static final String COMMAND_PARAMETER = "command";
    private static final String SIGN_UP_PAGE_COMMAND = "sign_up_page";
    private static final String SIGN_UP_COMMAND = "sign_up";

    @Override
    public void init(FilterConfig filterConfig) {
        for (CommandRegistry command : CommandRegistry.values()) {
            ROLES_BY_COMMANDS.put(command.getPath(), command.getAllowedRoles());
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String command = request.getParameter(COMMAND_PARAMETER);
        System.out.println(command);

        if (command == null) {
            System.out.println(1);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(LOGIN_JSP);
            dispatcher.forward(servletRequest, servletResponse);
        }

        Role currentRole = (Role) session.getAttribute(ROLE_ATTRIBUTE);

        if (currentRole == null) {
            authentication(servletRequest, servletResponse, filterChain, command);
            if (session.getAttribute(LOGIN_ATTRIBUTE) == null) {
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(LOGIN_JSP);
                dispatcher.forward(servletRequest, servletResponse);
            }
        } else {
            if (currentRole == Role.USER) {
                Status currentStatus = (Status) session.getAttribute(STATUS_ATTRIBUTE);
                if (currentStatus == Status.BANNED) {
                    RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(BANNED_JSP);
                    dispatcher.forward(servletRequest, servletResponse);
                }
            }
            List<Role> roles = ROLES_BY_COMMANDS.get(command);
            if (roles.contains(currentRole)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(ERROR_JSP);
                request.setAttribute("errorMessage", "no access");
                dispatcher.forward(servletRequest, servletResponse);
            }
        }
    }

    public void authentication(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, String command) throws ServletException, IOException {
        System.out.println(command);
        if (command.equals(SIGN_UP_PAGE_COMMAND)) {
            System.out.println(2);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(SIGN_UP_JSP);
            dispatcher.forward(servletRequest, servletResponse);
        } else if (command.equals(SIGN_UP_COMMAND)) {
            System.out.println(3);
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (!command.equals(LOGIN_ATTRIBUTE)) {
            System.out.println(4);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(LOGIN_JSP);
            dispatcher.forward(servletRequest, servletResponse);
        } else {
            System.out.println(5);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}