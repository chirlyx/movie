package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.Category;
import com.epam.movie.model.Movie;
import com.epam.movie.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class CreateMovieCommand implements Command {
    private static final String PATH = "C:\\Users\\User\\Documents\\0\\жаба\\movie\\src\\main\\webapp\\static\\data";
    private static final String FILE_EXTENSION = ".jpg";

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

        Integer year = Integer.parseInt(requestYear);
        Integer categoryId = Category.valueOf(categoryName).getCategoryId();

        Integer movieId = movieService.create(new Movie(title, year, categoryId, description));

        saveImage(request, movieId);

        return CommandResult.redirect("controller?command=show_movies&page=1");
    }

    private void saveImage(HttpServletRequest request, Integer movieId) {
        File uploadDir = new File(PATH);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            for (Part part : request.getParts()) {
                String fileName = part.getSubmittedFileName();
                if (fileName != null) {
                    part.write(PATH + File.separator + movieId + FILE_EXTENSION);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
