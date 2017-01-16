package com.robertson.userManagement.service;

import com.robertson.userManagement.dao.UsersDao;
import com.robertson.userManagement.model.User;
import com.robertson.userManagement.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDao usersDao;

    @Override
    @Transactional
    public void addUser(User user) {
        usersDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public void updateUser(User user) throws DuplicateException {
        if (user.equals(usersDao.getUserById(user.getId()))) throw new DuplicateException("В базе данных уже имется такой пользователь! Для обновления пользователя измените значение полей!");
        usersDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        usersDao.deleteUser(id);
    }
}
