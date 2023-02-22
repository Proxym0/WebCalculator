package by.tms.web;

import by.tms.entity.User;
import by.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Optional;

import static by.tms.storage.Constanta.*;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<User> user = userService.create(username, name, password);

        PrintWriter writer = resp.getWriter();
        user.ifPresentOrElse(
                o -> writer.append("hello ").append(o.getFirstName()),
                () -> writer.write("Such a user already exists. Choose a different nickname.")
        );
    }
}

//                user.ifPresentOrElse(
//                        o-> writer.append("hello ").append(o.getFirstName()),
//                        ()-> writer.write("Such a user already exists. Choose a different nickname.")
//                );