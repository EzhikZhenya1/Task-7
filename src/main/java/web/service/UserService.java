package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User findUserById(int id);
    List<User> findAllUsers();
}