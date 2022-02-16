package com.epam.movie.filter;

import com.epam.movie.model.BanStatus;
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

@WebFilter(filterName = "banFilter")
public class BanFilter implements Filter {
    private static final String BANNED_JSP = "WEB-INF/view/banned.jsp";

    private static final String ROLE_ATTRIBUTE = "role";
    private static final String BAN_STATUS_ATTRIBUTE = "banStatus";
    private static final String COMMAND_PARAMETER = "command";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        Role currentRole = (Role) session.getAttribute(ROLE_ATTRIBUTE);
        BanStatus currentBanStatus = (BanStatus) session.getAttribute(BAN_STATUS_ATTRIBUTE);
        String command = request.getParameter(COMMAND_PARAMETER);

        if (currentRole != null
                && currentRole.equals(Role.USER)
                && currentBanStatus != null
                && currentBanStatus.equals(BanStatus.BANNED) && (!command.equals("logout")) && (!command.equals("show_login_page"))) {
            // ((HttpServletResponse) servletRequest).sendRedirect(BANNED_JSP);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(BANNED_JSP);
            dispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
