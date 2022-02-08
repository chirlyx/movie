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

public class UpdateMovieCommand implements Command {
    private static final String PATH = "C:\\Users\\User\\Documents\\0\\жаба\\movie\\src\\main\\webapp\\static\\data";
    private static final String FILE_EXTENSION = ".jpg";

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

        deletePreviousPoster(id);
        uploadNewPoster(request, id);

        Movie movie = movieService.retrieveById(id);
        request.setAttribute("movie", movie);

        return CommandResult.redirect("controller?command=show_movies&page=1");
    }

    private void uploadNewPoster(HttpServletRequest request, Integer id) {
        File uploadDir = new File(PATH);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            for (Part part : request.getParts()) {
                String fileName = part.getSubmittedFileName();
                if (fileName != null) {
                    part.write(PATH + File.separator + id + FILE_EXTENSION);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void deletePreviousPoster(Integer id) {
        try {
            File moviePoster = new File(PATH + File.separator + id + FILE_EXTENSION);
            moviePoster.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
