package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.*;
import com.epam.movie.service.MovieService;
import com.epam.movie.service.ReviewService;
import com.epam.movie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubmitReviewCommand implements Command {

    private final ReviewService reviewService;
    private final MovieService movieService;
    private final UserService userService;

    public SubmitReviewCommand(ReviewService reviewService, MovieService movieService, UserService userService) {
        this.reviewService = reviewService;
        this.movieService = movieService;
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        String requestMovieId = request.getParameter("movie");
        String requestMark = request.getParameter("mark");
        String comment = request.getParameter("comment");

        int userId = account.getId();
        int movieId = Integer.parseInt(requestMovieId);
        int mark = Integer.parseInt(requestMark);

        Review review = reviewService.submit(new Review(userId, movieId, mark, comment));

        if (reviewService.isReview(userId, movieId)) {
            request.setAttribute("isReview", true);
            request.setAttribute("mark", review.getMark());
            request.setAttribute("comment", review.getComment());
        }
        Movie movie = movieService.retrieveById(movieId);
        request.setAttribute("movie", movie);

        Integer reviewCount = reviewService.retrieveCountByUser(userId);
        Status updatedStatus = Status.byNumberOfReviews(reviewCount);
        User user = (User) session.getAttribute("user");
        user.setStatus(updatedStatus);
        userService.update(user);
        session.setAttribute("user", user);

        return CommandResult.redirect("controller?command=single_movie_page&movie=" + movieId);
    }
}
