package com.epam.movie.command;

import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.service.MovieService;
import com.epam.movie.service.UserService;

public class CommandFactory {
    private UserService userService = new UserService(new DaoHelperFactory());
    private MovieService movieService = new MovieService(new DaoHelperFactory());

    public Command create (String type) {

        switch (type) {
            case "login":
                return new LoginCommand(userService);
            case "show_movies":
                return new ShowMoviePageCommand(movieService);

            default:
                return null;
        }
    }
}
