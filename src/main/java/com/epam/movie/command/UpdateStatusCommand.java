package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.BanStatus;
import com.epam.movie.model.User;
import com.epam.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class UpdateStatusCommand implements Command {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateStatusCommand.class);

    private final UserService userService;

    public UpdateStatusCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String requestUserId = request.getParameter("user");
        String banStatusName = request.getParameter("banStatus");

        Integer userId = Integer.parseInt(requestUserId);
        Integer banStatusId;
        try {
            banStatusId = BanStatus.valueOf(banStatusName.toUpperCase(Locale.ROOT)).getBanStatusId();
        } catch (IllegalArgumentException e) {
            LOG.error(e.getMessage(), e);
            return CommandResult.forward("WEB-INF/view/error.jsp");
        }

        User user = userService.retrieveById(userId);
        userService.update(new User(userId, user.getFirstName(), user.getLastName(), user.getStatus().getStatusId(), banStatusId));

        return CommandResult.redirect("controller?command=show_users&page=1");
    }
}
