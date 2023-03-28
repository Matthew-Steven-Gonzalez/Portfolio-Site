package java.java.com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");


        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
        }

        if (username == null || email == null || password == null) {
            response.sendRedirect("/register");
            return;
        }
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("/register");
            return;
        }
        if(inputHasErrors){
            response.sendRedirect("/register");
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/profile");

    }
}




