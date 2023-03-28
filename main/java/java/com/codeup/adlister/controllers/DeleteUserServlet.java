package java.java.com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/users/delete")
public class DeleteUserServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
//      Using similar logic to the delete ad servlet we are retrieving from the JSP parameter "deleteMe"
        String username = req.getParameter("deleteMe");
        DaoFactory.getUsersDao().deleteUserByUsername(username);
//      Here we use .invalidate to essentially wipe clean the session. This was added due to persistence of the profile page after delete query was instanced.
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }
}
