package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.service.MovieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestoreMovieCommand implements Command{
    private final MovieService movieService;

    public RestoreMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestId = request.getParameter("movie");
        Integer id = Integer.parseInt(requestId);

        movieService.restore(id);

        return CommandResult.redirect("controller?command=show_deleted_movies&page=1");
    }
}
