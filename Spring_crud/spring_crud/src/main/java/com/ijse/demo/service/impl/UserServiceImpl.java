package com.ijse.demo.service.impl;

import com.ijse.demo.dto.UserDTO;
import com.ijse.demo.entity.User;
import com.ijse.demo.repo.UserRepo;
import com.ijse.demo.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public User saveUser(UserDTO userDTO) {
        return userRepo.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList = userRepo.findAll();

        return modelMapper.map(
                userList,
                new TypeToken<List<UserDTO>>(){}.getType());

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;

    }

    @Override
    public boolean deleteUser(int id) {
        Optional<User> byId = userRepo.findById(id);
        if (byId.isEmpty()) {
            throw new IllegalStateException("User id "+id+" does not exists ..");
        }
        userRepo.deleteById(id);
        return true;
    }

    @Override
    public UserDTO getUserById(int id) {
        User user = userRepo.getUserByUserId(id);
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    public UserDTO getUserByNameAndAddress(String name, String address) {
        User user = userRepo.getUserByNameAndAddress(name, address);
        return modelMapper.map(user,UserDTO.class);
    }
}
