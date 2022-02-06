package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Account;
import com.epam.movie.model.Movie;
import com.epam.movie.model.Review;
import com.epam.movie.model.User;
import com.epam.movie.service.MovieService;
import com.epam.movie.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowUserProfilePageCommand implements Command{

    private final ReviewService reviewService;
    private final MovieService movieService;

    public ShowUserProfilePageCommand(ReviewService reviewService, MovieService movieService) {
        this.reviewService = reviewService;
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Review> reviewList = reviewService.retrieveByUser(user.getId());
        List<Movie> movieList = new ArrayList<>();
        int count = 0;
        if(!reviewList.isEmpty()){
            for (Review review:reviewList) {
                count++;
                movieList.add(movieService.retrieveById(review.getMovieId()));
            }
        }

        request.setAttribute("movies", movieList);
        request.setAttribute("count", count);

        return CommandResult.forward("WEB-INF/view/profile.jsp");
    }
}
