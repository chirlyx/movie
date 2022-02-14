package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;
import com.epam.movie.model.Movie;
import com.epam.movie.model.Status;
import com.epam.movie.model.User;
import com.epam.movie.service.ReviewService;
import com.epam.movie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteReviewFromProfileCommand implements Command{
    private final ReviewService reviewService;
    private final UserService userService;

    public DeleteReviewFromProfileCommand(ReviewService reviewService, UserService userService) {
        this.reviewService = reviewService;
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String requestMovieId = request.getParameter("movie");

        int userId = account.getId();
        int movieId = Integer.parseInt(requestMovieId);

        reviewService.delete(userId, movieId);

        Integer reviewCount = reviewService.retrieveCountByUser(userId);
        Status updatedStatus = Status.byNumberOfReviews(reviewCount);
        User user = (User) session.getAttribute("user");
        user.setStatus(updatedStatus);
        userService.update(user);
        session.setAttribute("user", user);
        return CommandResult.redirect("controller?command=profile");
    }
}
