package com.robertson.userManagement.dao;

import com.robertson.userManagement.model.User;

import java.util.List;

public interface UsersDao {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);
}
