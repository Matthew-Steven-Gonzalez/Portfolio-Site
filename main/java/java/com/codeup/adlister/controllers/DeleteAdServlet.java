package java.java.com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Checking to verify user is logged in via presence of a user. If not redirected to /login
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
//      Using the parameter "deleteMe" from the form on hte jsp it is able to delete the ad by id.
        int id = Integer.parseInt(req.getParameter("deleteMe"));
        DaoFactory.getAdsDao().deleteAdById(id);
        resp.sendRedirect("/ads");
    }


}
