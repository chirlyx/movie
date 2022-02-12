package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;
import com.epam.movie.model.User;
import com.epam.movie.service.AccountService;
import com.epam.movie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpCommand implements Command {

    private final UserService userService;
    private final AccountService accountService;

    public SignUpCommand(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Account account = new Account(login, password);
        User user = new User(accountService.create(account), firstName, lastName, 1, 1);
        userService.create(user);

        return CommandResult.forward("index.jsp");
    }
}
