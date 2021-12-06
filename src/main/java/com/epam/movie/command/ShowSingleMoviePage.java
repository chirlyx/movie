package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowSingleMoviePage implements Command{

    private final MovieService movieService;

    public ShowSingleMoviePage(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestMovieId = request.getParameter("movie");
        int movieId = Integer.parseInt(requestMovieId);

        Movie movie = movieService.retrieveById(movieId);

        request.setAttribute("movie", movie);

        return CommandResult.forward("WEB-INF/view/movie.jsp");
    }
}
