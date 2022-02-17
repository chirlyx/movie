package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;
import com.epam.movie.validation.Validator;
import com.epam.movie.validation.ValidatorFactory;
import com.epam.movie.validation.ValidatorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowDeletedMoviePageCommand implements Command{
    private final static int RECORDS_LIMIT = 5;

    private final ValidatorFactory validatorFactory = new ValidatorFactory();

    private final MovieService movieService;

    public ShowDeletedMoviePageCommand(MovieService movieService) {
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

        int numberOfRecords = movieService.numberOfDeletedMovies();
        Integer numberOfPages = (int) Math.ceil((double) numberOfRecords / (double) RECORDS_LIMIT);
        if (page>numberOfPages){
            return CommandResult.forward("WEB-INF/view/error.jsp");
        }

        final List<Movie> movies = movieService.retrieveDeletedFromTo(page, RECORDS_LIMIT);

        request.setAttribute("movies", movies);
        request.setAttribute("numberOfPages", numberOfPages);

        return CommandResult.forward("WEB-INF/view/moviesDeleted.jsp");
    }

    private boolean validatePage(String page) {
        Validator validator = validatorFactory.create(ValidatorRegistry.ID, page);
        return validator.isValid(page, ValidatorRegistry.ID);
    }
}
