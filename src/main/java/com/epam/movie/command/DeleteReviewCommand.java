package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;
import com.epam.movie.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteReviewCommand implements Command {
    private final ReviewService reviewService;
    private final MovieService movieService;

    public DeleteReviewCommand(ReviewService reviewService, MovieService movieService) {
        this.reviewService = reviewService;
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        String requestMovieId = request.getParameter("movie");

        int userId = account.getId();
        int movieId = Integer.parseInt(requestMovieId);

        if (reviewService.delete(userId, movieId)){
            request.setAttribute("isReview", false);
        }

        Movie movie = movieService.retrieveById(movieId);
        request.setAttribute("movie", movie);

        return CommandResult.forward("WEB-INF/view/movie.jsp");
    }
}
