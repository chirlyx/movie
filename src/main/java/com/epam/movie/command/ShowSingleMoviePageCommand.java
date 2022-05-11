package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;
import com.epam.movie.model.Movie;
import com.epam.movie.model.Review;
import com.epam.movie.service.MovieService;
import com.epam.movie.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSingleMoviePageCommand implements Command {

    private final MovieService movieService;
    private final ReviewService reviewService;

    public ShowSingleMoviePageCommand(MovieService movieService, ReviewService reviewService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        String requestMovieId = request.getParameter("movie");
        int movieId = Integer.parseInt(requestMovieId);
        int userId = account.getId();

        Boolean isReview = reviewService.isReview(userId, movieId);
        Movie movie = movieService.retrieveById(movieId);

        if (isReview) {
            Review review = reviewService.retrieveByUserAndMovieId(userId, movieId);
            request.setAttribute("mark", review.getMark());
            request.setAttribute("comment", review.getComment());

        }

        request.setAttribute("movie", movie);
        request.setAttribute("isReview", isReview);

        return CommandResult.forward("WEB-INF/view/movie.jsp");
    }
}
