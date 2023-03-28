package java.java.com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    @Override
    public List<Ad> searchAds(String searchString) throws SQLException {
        String sql = "SELECT * FROM ads WHERE title LIKE ? || description LIKE ?";
        String searchTermWithWildcards = "%" + searchString + "%";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, searchTermWithWildcards);
        stmt.setString(2, searchTermWithWildcards);

        ResultSet rs = stmt.executeQuery();
        List<Ad> ads = createAdsFromResults(rs);
        return ads;
    }
    @Override
    public Ad searchAdsByTitle(String searchString) throws SQLException {
        String query = "SELECT * FROM ads WHERE title = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, searchString);
            return extractAd(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
//
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public void deleteAdById(int id) {
        try {
            String deleteQuery = "DELETE FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(deleteQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting new ad.", e);
        }
    }


    @Override
    public Ad getAdById(int id) {
        Ad ad;
        ad = null;
        try {
            String searchById = "SELECT * FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(searchById, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ad = new Ad(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"));
            }
            return ad;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding id based on input.", e);
        }
    }

//     Method for updating an ad in the DB
    public void updateAd(Ad ad) {
        try {
            String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.setInt(3, (int) ad.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad", e);
        }
    }

}
