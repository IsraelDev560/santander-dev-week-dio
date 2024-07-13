package me.dio.service;

import me.dio.model.Account;
import me.dio.model.Card;
import me.dio.model.Feature;
import me.dio.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    List<User> findAllUsers(String name);

    User deleteUser(Long id);

    User updateUser(Long id, User userToUpdate);
}
