package com.alexcompany.springsecurity62.service;

import com.alexcompany.springsecurity62.dto.UserDTO;
import com.alexcompany.springsecurity62.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findOne(Long id);
    Optional<User> findOne(String username);
    void delete(Long id);
    void delete(String username);
    List<User> findAll();
    void registerNewUser(UserDTO userDTO);
}
