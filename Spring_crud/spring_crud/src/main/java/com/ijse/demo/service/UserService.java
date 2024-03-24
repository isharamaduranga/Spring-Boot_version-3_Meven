package com.ijse.demo.service;

import com.ijse.demo.dto.UserDTO;
import com.ijse.demo.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO dto);

    List<UserDTO> getAllUser();

    UserDTO updateUser(UserDTO userDTO);

    boolean deleteUser(int id );

    UserDTO getUserById(int id);

    UserDTO getUserByNameAndAddress(String name,String address);
}
