package web.service;

import web.model.User;

import java.util.List;

public interface Service {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
