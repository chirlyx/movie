package com.epam.movie.command;

import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.service.UserService;

public class CommandFactory {
    private UserService userService = new UserService(new DaoHelperFactory());

    public Command create (String type) {

        switch (type) {
            case "login":
                return new LoginCommand(userService);

            default:
                return null;
        }
    }
}
