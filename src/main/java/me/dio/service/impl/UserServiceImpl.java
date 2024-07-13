package me.dio.service.impl;

import me.dio.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public List<User> findAllUsers(String name) {
        if (name == null || name.isEmpty()) {
            return userRepository.findAll();
        }
        return userRepository.findByNameIgnoreCase(name);
    }

    @Override
    public User updateUser(Long id, User userToUpdate) {
        User existingUser = findById(id);
        if (existingUser == null) {
            throw new NoSuchElementException("User not found with ID: " + id);
        }
        userToUpdate.setId(id);
        return userRepository.save(userToUpdate);
    }

    @Override
    public User deleteUser(Long id) {
        User user = findById(id);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }
}

