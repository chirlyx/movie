package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Category;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMovieCommand implements Command {
    private final MovieService movieService;

    public UpdateMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestId = request.getParameter("movie");
        String title = request.getParameter("title");
        String requestYear = request.getParameter("year");
        String categoryName = request.getParameter("category");

        Integer id = Integer.parseInt(requestId);
        Integer year = Integer.parseInt(requestYear);
        Integer categoryId = Category.valueOf(categoryName).getCategoryId();

        movieService.update(new Movie(id, title, year, categoryId));

        Movie movie = movieService.retrieveById(id);
        request.setAttribute("movie", movie);

        return CommandResult.redirect("controller?command=show_movies&page=1");
    }
}
