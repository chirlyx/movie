package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Category;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowEditMoviePageCommand implements Command {
    private final MovieService movieService;

    public ShowEditMoviePageCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestMovie = request.getParameter("movie");
        List<Category> categories = Category.valuesAsList();

        if (requestMovie == null || requestMovie.isEmpty()) {
            return CommandResult.forward("WEB-INF/view/error.jsp");
        }

        if (requestMovie.equals("new")) {
            request.setAttribute("action", "create");
            request.setAttribute("categories", categories);
        }
        else {
            try {
                int movieId = Integer.parseInt(requestMovie);
                Movie movie = movieService.retrieveById(movieId);

                request.setAttribute("action", "update");
                request.setAttribute("movie", movie);
                request.setAttribute("categories", categories);
            } catch (final NumberFormatException e) {
                return CommandResult.forward("WEB-INF/view/error.jsp");
            }
        }
        return CommandResult.forward("WEB-INF/view/movieEdit.jsp");
    }
}
