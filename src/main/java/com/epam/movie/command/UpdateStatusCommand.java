package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.BanStatus;
import com.epam.movie.model.User;
import com.epam.movie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class UpdateStatusCommand implements Command {
    private final UserService userService;

    public UpdateStatusCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestUserId = request.getParameter("user");
        String banStatusName = request.getParameter("banStatus");

        Integer userId = Integer.parseInt(requestUserId);
        Integer banStatusId = BanStatus.valueOf(banStatusName.toUpperCase(Locale.ROOT)).getBanStatusId();

        User user = userService.retrieveById(userId);
        userService.update(new User(userId, user.getFirstName(), user.getLastName(), user.getStatus().getStatusId(), banStatusId));

        return CommandResult.redirect("controller?command=show_users&page=1");
    }
}
