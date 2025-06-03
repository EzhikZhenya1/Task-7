package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User findUserById(int id);
    List<User> findAllUsers();
}
