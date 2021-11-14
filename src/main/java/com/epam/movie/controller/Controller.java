package com.epam.movie.controller;

import com.epam.movie.command.Command;
import com.epam.movie.command.CommandFactory;
import com.epam.movie.command.CommandResult;
import com.epam.movie.db.LockingConnectionPool;
import com.epam.movie.exception.ServiceException;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/controller")
public class Controller extends HttpServlet {

    private final CommandFactory commandFactory = new CommandFactory();

    @Override
    public void init() throws ServletException {
        LockingConnectionPool.INSTANCE.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandType = request.getParameter("command");
        Command command = commandFactory.create(commandType);
        CommandResult result = null;
        try {
            result = command.execute(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        String path = result.getPath();
        boolean isRedirect = result.isRedirect();
        if (isRedirect) {
            response.sendRedirect(path);
        } else {
            request.getRequestDispatcher(path).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}