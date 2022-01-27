package com.epam.movie.command;

import com.epam.movie.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command{
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session=request.getSession();
        session.invalidate();
        return CommandResult.redirect("controller");
    }
}
