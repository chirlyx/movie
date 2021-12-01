package com.epam.movie.filter;

import com.epam.movie.command.CommandRegistry;
import com.epam.movie.model.Role;

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

@WebFilter(urlPatterns = "/*")
public class RoleFilter implements Filter {

    private static final Map<String, List<Role>> ROLES_BY_COMMANDS = new HashMap<>();

    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String LOGIN_PAGE = "index.jsp";
    private static final String LOGIN_ATTRIBUTE = "login";
    public static final String ROLE_ATTRIBUTE = "role";
    public static final String COMMAND_PARAMETER = "command";
    public static final String SIGN_UP_PAGE = "sign_up_page";
    public static final String SIGN_UP_COMMAND = "sign_up";
    public static final String REGISTRATION_COMMAND = "registration";

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

        if (command == null) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(LOGIN_PAGE);
            dispatcher.forward(servletRequest, servletResponse);
        }

        Role currentRole = (Role) session.getAttribute(ROLE_ATTRIBUTE);

        if (currentRole == null) {
            authentication(servletRequest, servletResponse, filterChain, command);
            if (session.getAttribute(LOGIN_ATTRIBUTE) == null) {
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(LOGIN_PAGE);
                dispatcher.forward(servletRequest, servletResponse);
            }
        } else {
            List<Role> roles = ROLES_BY_COMMANDS.get(command);
            if (roles.contains(currentRole)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(ERROR_PAGE);
                request.setAttribute("errorMessage", "no access");
                dispatcher.forward(servletRequest, servletResponse);
            }
        }
    }

    public void authentication(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, String command) throws ServletException, IOException {
        if (command.equals(SIGN_UP_PAGE)) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("WEB-INF/view/signup.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        } else if (command.equals(SIGN_UP_COMMAND)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (!command.equals(LOGIN_ATTRIBUTE)) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(LOGIN_PAGE);
            dispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

