package com.robertson.userManagement.service;

import com.robertson.userManagement.model.User;
import com.robertson.userManagement.exception.DuplicateException;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public List<User> getAllUsers();

    public void updateUser(User user) throws DuplicateException;

    public void deleteUser(int id);
}
