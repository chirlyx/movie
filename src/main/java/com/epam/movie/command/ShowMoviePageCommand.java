package com.epam.movie.command;

import com.epam.movie.dao.MovieDao;
import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowMoviePageCommand implements Command {
    private final MovieService movieService;

    private final static int RECORDS_LIMIT = 5;

    public ShowMoviePageCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestPage = request.getParameter("page");
        int page = Integer.parseInt(requestPage);
        request.setAttribute("currentPage", page);
        if (page != 1) {
            page = page - 1;
            page = page * RECORDS_LIMIT + 1;
        }
        int numberOfRecords = movieService.numberOfRecords();
        Integer numberOfPages = (int) Math.ceil((double) numberOfRecords / (double) RECORDS_LIMIT);

        final List<Movie> movies = movieService.retrieveFromTo(page, RECORDS_LIMIT);

        request.setAttribute("movies", movies);
        request.setAttribute("numberOfPages", numberOfPages);

        return CommandResult.forward("WEB-INF/view/movies.jsp");
    }
}
