package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Category;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateMovieCommand implements Command{
    private final MovieService movieService;

    public CreateMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String title = request.getParameter("title");
        String requestYear = request.getParameter("year");
        String categoryName = request.getParameter("category");

        Integer year = Integer.parseInt(requestYear);
        Integer categoryId = Category.valueOf(categoryName).getCategoryId();

        movieService.create(new Movie(title, year, categoryId));

        return CommandResult.redirect("controller?command=show_movies&page=1");
    }
}
