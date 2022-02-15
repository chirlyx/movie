package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.*;
import com.epam.movie.service.AccountService;
import com.epam.movie.service.UserService;
import com.epam.movie.validation.Validator;
import com.epam.movie.validation.ValidatorFactory;
import com.epam.movie.validation.ValidatorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private final ValidatorFactory validatorFactory = new ValidatorFactory();

    private final UserService userService;
    private final AccountService accountService;

    public LoginCommand(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (validateLogin(login) && validatePassword(password)) {
            if (accountService.checkLoginAndPassword(login, password)) {
                Account account = accountService.retrieveByLogin(login);
                Role role = account.getRole();

                session.setAttribute("account", account);
                session.setAttribute("login", login);
                session.setAttribute("role", role);

                return isUserBanned(session, account, role)
                        ? CommandResult.forward("WEB-INF/view/banned.jsp")
                        : CommandResult.forward("WEB-INF/view/main.jsp");
            } else {
                request.setAttribute("errorLogin", "Incorrect password or login");
                return CommandResult.forward("index.jsp");
            }
        }
        request.setAttribute("errorLogin", "Incorrect password or login");
        return CommandResult.forward("index.jsp");
    }

    private boolean validateLogin(String login) {
        Validator validator = validatorFactory.create(ValidatorRegistry.LOGIN, login);
        return validator.isValid(login, ValidatorRegistry.LOGIN);
    }

    private boolean validatePassword(String password) {
        Validator validator = validatorFactory.create(ValidatorRegistry.PASSWORD, password);
        return validator.isValid(password, ValidatorRegistry.PASSWORD);
    }

    private boolean isUserBanned(HttpSession session, Account account, Role role) throws ServiceException {
        if (role == Role.USER) {
            Integer id = account.getId();
            User user = userService.retrieveById(id);
            BanStatus banStatus = user.getBanStatus();
            session.setAttribute("user", user);
            session.setAttribute("banStatus", banStatus);
            return banStatus == BanStatus.BANNED;
        } else {
            return false;
        }
    }
}
