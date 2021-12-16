package com.epam.movie.command;

import com.epam.movie.dao.DaoHelperFactory;
import com.epam.movie.service.AccountService;
import com.epam.movie.service.MovieService;
import com.epam.movie.service.ReviewService;
import com.epam.movie.service.UserService;

public class CommandFactory {
    private UserService userService = new UserService(new DaoHelperFactory());
    private MovieService movieService = new MovieService(new DaoHelperFactory());
    private AccountService accountService = new AccountService(new DaoHelperFactory());
    private ReviewService reviewService = new ReviewService(new DaoHelperFactory());

    public Command create(String type) {

        switch (type) {
            case "login":
                return new LoginCommand(userService, accountService);
            case "show_movies":
                return new ShowMoviePageCommand(movieService);
            case "main_page":
                return new ShowMainPageCommand();
            case "sign_up_page":
                return new ShowSignUpPageCommand();
            case "sign_up":
                return new SignUpCommand(userService, accountService);
            case "single_movie_page":
                return new ShowSingleMoviePageCommand(movieService, reviewService);
            case "submit_review":
                return new SubmitReviewCommand(reviewService, movieService);
            case "delete_review":
                return new DeleteReviewCommand(reviewService, movieService);
            case "edit_movie":
                return new ShowEditMoviePageCommand(movieService);
            case "delete_movie":
                return new DeleteMovieCommand(movieService);
            case "update_movie":
                return new UpdateMovieCommand(movieService);
            case "create_movie":
                return new CreateMovieCommand(movieService);
            default:
                return null;
        }
    }
}
