package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;
import com.epam.movie.model.User;
import com.epam.movie.service.AccountService;
import com.epam.movie.service.UserService;
import com.epam.movie.validation.Validator;
import com.epam.movie.validation.ValidatorFactory;
import com.epam.movie.validation.ValidatorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpCommand implements Command {
    private final ValidatorFactory validatorFactory = new ValidatorFactory();

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

        if (validateLogin(login) && validatePassword(password) && validateName(firstName) && validateName(lastName)) {

            Account account = new Account(login, password);
            User user = new User(accountService.create(account), firstName, lastName, 1, 1);
            userService.create(user);

            return CommandResult.forward("index.jsp");
        }
        request.setAttribute("errorLogin", "Incorrect data format, try again");
        return CommandResult.forward("WEB-INF/view/signup.jsp");
    }

    private boolean validateLogin(String login) {
        Validator validator = validatorFactory.create(ValidatorRegistry.LOGIN, login);
        return validator.isValid(login, ValidatorRegistry.LOGIN);
    }

    private boolean validatePassword(String password) {
        Validator validator = validatorFactory.create(ValidatorRegistry.PASSWORD, password);
        return validator.isValid(password, ValidatorRegistry.PASSWORD);
    }

    private boolean validateName(String name) {
        Validator validator = validatorFactory.create(ValidatorRegistry.NAME, name);
        return validator.isValid(name, ValidatorRegistry.NAME);
    }


}
