package java.java.com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndividualAdServlet", urlPatterns = "/ads/single/*")
public class IndividualAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adId = Integer.parseInt(request.getParameter("adID"));
        System.out.println(adId);
        Ad ad = DaoFactory.getAdsDao().getAdById(adId);
        System.out.println(ad.getTitle());
//        int userId = (int) ad.getUserId();
        request.setAttribute("Ad", ad);
        request.getRequestDispatcher("/WEB-INF/ads/single.jsp").forward(request,response);

    }
}
