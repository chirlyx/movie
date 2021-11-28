package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.service.AccountService;
import com.epam.movie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    private final UserService userService;
    private final AccountService accountService;

    public LoginCommand(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (accountService.checkLoginAndPassword(login, password)) {
            return CommandResult.forward("WEB-INF/view/main.jsp");
        } else {
            request.setAttribute("errorLogin", "Incorrect password or login");
            return CommandResult.forward("index.jsp");
        }
    }

}
