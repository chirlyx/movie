package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class DeleteMovieCommand implements Command {
    private static final String PATH = "C:\\Users\\User\\Documents\\0\\жаба\\movie\\src\\main\\webapp\\static\\data";
    private static final String FILE_EXTENSION = ".jpg";

    private static final String SHOW_MOVIES_COMMAND = "controller?command=show_movies&page=1";
    private static final String MOVIE_PARAMETER = "movie";

    private final MovieService movieService;

    public DeleteMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestId = request.getParameter(MOVIE_PARAMETER);
        Integer id = Integer.parseInt(requestId);

        movieService.delete(id);

        //deletePoster(id);

        return CommandResult.redirect(SHOW_MOVIES_COMMAND);
    }

    private void deletePoster(Integer id) {
        try {
            File moviePoster = new File(PATH + File.separator + id + FILE_EXTENSION);
            moviePoster.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
