package com.epam.movie.command;

import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.service.AccountService;
import com.epam.movie.service.MovieService;
import com.epam.movie.service.UserService;

public class CommandFactory {
    private UserService userService = new UserService(new DaoHelperFactory());
    private MovieService movieService = new MovieService(new DaoHelperFactory());
    private AccountService accountService = new AccountService(new DaoHelperFactory());

    public Command create(String type) {

        switch (type) {
            case "login":
                return new LoginCommand(userService);
            case "show_movies":
                return new ShowMoviePageCommand(movieService);
            case "sign_up_page":
                return new ShowSignUpPageCommand();
            case "sign_up":
                return new SignUpCommand(userService, accountService);

            default:
                return null;
        }
    }
}
