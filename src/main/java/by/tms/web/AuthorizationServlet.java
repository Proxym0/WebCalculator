package by.tms.web;

import by.tms.entity.User;
import by.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth")
public class AuthorizationServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUserName = userService.findByUserName(username);
        if (byUserName.isPresent()) {
            User user = byUserName.get();
            resp.getWriter().println("Hello "+ byUserName);
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser",user);
            }else {
                resp.getWriter().println("Wrong password.");
            }
        }else {
            resp.getWriter().println("User not found.");
        }
    }
}
