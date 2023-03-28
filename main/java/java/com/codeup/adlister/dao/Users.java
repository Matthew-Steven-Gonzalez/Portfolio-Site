package java.java.com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);

    void deleteUserByUsername( String username);

    void updateUser(User user);
}
