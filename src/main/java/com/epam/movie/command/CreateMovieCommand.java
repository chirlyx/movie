package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Category;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;
import com.epam.movie.validation.Validator;
import com.epam.movie.validation.ValidatorFactory;
import com.epam.movie.validation.ValidatorRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class CreateMovieCommand implements Command {
    private static final String PATH = "C:\\Users\\User\\Documents\\0\\жаба\\movie\\src\\main\\webapp\\static\\data";
    private static final String DIRECTORY = "data";
    private static final String FILE_EXTENSION = ".jpg";

    private static final Logger LOG = LoggerFactory.getLogger(CreateMovieCommand.class);

    private final ValidatorFactory validatorFactory = new ValidatorFactory();

    private final MovieService movieService;

    public CreateMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String title = request.getParameter("title");
        String requestYear = request.getParameter("year");
        String categoryName = request.getParameter("category");
        String description = request.getParameter("description");

        if (validateTitle(title) && validateYear(requestYear) && validateDescription(description)) {
            Integer year = Integer.parseInt(requestYear);
            Integer categoryId = Category.valueOf(categoryName.toUpperCase(Locale.ROOT)).getCategoryId();

            Integer movieId = movieService.create(new Movie(title, year, categoryId, description));

            saveImage(request, movieId);

            return CommandResult.redirect("controller?command=show_movies&page=1");
        } else {
            request.setAttribute("errorInput", "Incorrect data format, try again");
            return CommandResult.redirect("controller?command=edit_movie&movie=new");
        }
    }

    private boolean validateTitle(String title) {
        Validator validator = validatorFactory.create(ValidatorRegistry.TITLE, title);
        return validator.isValid(title, ValidatorRegistry.TITLE);
    }

    private boolean validateYear(String year) {
        Validator validator = validatorFactory.create(ValidatorRegistry.YEAR, year);
        return validator.isValid(year, ValidatorRegistry.YEAR);
    }

    private boolean validateDescription(String description) {
        Validator validator = validatorFactory.create(ValidatorRegistry.DESCRIPTION, description);
        return validator.isValid(description, ValidatorRegistry.DESCRIPTION);
    }

    private void saveImage(HttpServletRequest request, Integer movieId) {
        String uploadPath = request.getServletContext().getRealPath("") + File.separator + DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            for (Part part : request.getParts()) {
                String fileName = part.getSubmittedFileName();
                if (fileName != null) {
                    part.write(uploadPath + File.separator + movieId + FILE_EXTENSION);
                }
            }
        } catch (IOException | ServletException e) {
            LOG.debug(e.getMessage(), e);
        }
    }
}
