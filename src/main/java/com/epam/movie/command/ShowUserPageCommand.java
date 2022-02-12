package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;
import com.epam.movie.model.BanStatus;
import com.epam.movie.model.Status;
import com.epam.movie.model.User;
import com.epam.movie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUserPageCommand implements Command{
    private final UserService userService;

    private final static int RECORDS_LIMIT = 5;

    public ShowUserPageCommand(UserService userService) {
        this.userService = userService;
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
        int numberOfRecords = userService.numberOfRecords();
        Integer numberOfPages = (int) Math.ceil((double) numberOfRecords / (double) RECORDS_LIMIT);

        final List<User> users = userService.retrieveFromTo(page, RECORDS_LIMIT);

        request.setAttribute("users", users);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("banStatuses", BanStatus.valuesAsList());

        return CommandResult.forward("WEB-INF/view/users.jsp");
    }
}
