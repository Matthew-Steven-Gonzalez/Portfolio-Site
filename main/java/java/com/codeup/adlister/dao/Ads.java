package java.java.com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    // used to delete an ad.
    void deleteAdById(int id);

    Ad getAdById (int id);

    List<Ad> searchAds (String searchString) throws SQLException;

    Ad searchAdsByTitle(String searchString) throws SQLException;

    void updateAd(Ad ad);

}
