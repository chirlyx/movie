package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;
import com.epam.movie.validation.Validator;
import com.epam.movie.validation.ValidatorFactory;
import com.epam.movie.validation.ValidatorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

public class ShowMoviePageCommand implements Command {
    private static final String DIRECTORY = "http://localhost:8000/Users/User/Documents/0/%D0%B6%D0%B0%D0%B1%D0%B0/movie/target/movie-1.0-SNAPSHOT/data";
    private static final int RECORDS_LIMIT = 5;

    private final ValidatorFactory validatorFactory = new ValidatorFactory();

    private final MovieService movieService;

    public ShowMoviePageCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestPage = request.getParameter("page");
        int page = 1;

        if (validatePage(requestPage)) {
            page = Integer.parseInt(requestPage);
            request.setAttribute("currentPage", page);
            if (page != 1) {
                page = page - 1;
                page = page * RECORDS_LIMIT + 1;
            }
        } else {
            return CommandResult.forward("WEB-INF/view/error.jsp");
        }

        int numberOfRecords = movieService.numberOfActiveMovies();
        Integer numberOfPages = (int) Math.ceil((double) numberOfRecords / (double) RECORDS_LIMIT);
        if (page>numberOfPages){
            return CommandResult.forward("WEB-INF/view/error.jsp");
        }

        final List<Movie> movies = movieService.retrieveActiveFromTo(page, RECORDS_LIMIT);

        String path = DIRECTORY + File.separator;
        request.setAttribute("movies", movies);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("path", path);


        return CommandResult.forward("WEB-INF/view/movies.jsp");
    }

    private boolean validatePage(String page) {
        Validator validator = validatorFactory.create(ValidatorRegistry.ID, page);
        return validator.isValid(page, ValidatorRegistry.ID);
    }
}
