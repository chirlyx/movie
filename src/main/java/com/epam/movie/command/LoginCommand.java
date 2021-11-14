package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.User;
import com.epam.movie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        final String chirlyx = "chirlyx";
        final String admin = "admin";

        final Optional<User> user = userService.retrieveById(1);
        if (user.isPresent()){
            System.out.println(user.get().getFirstName());
        }
        System.out.println(login + " " + password);

        if (chirlyx.equals(login) && admin.equals(password)){
            return CommandResult.forward("WEB-INF/view/main.jsp");
        } else {
            request.setAttribute("errorLogin", "Incorrect password or login");
            return CommandResult.forward("index.jsp");
        }
    }

}
