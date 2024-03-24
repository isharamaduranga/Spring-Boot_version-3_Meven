package com.ijse.demo.controller;

import com.ijse.demo.dto.UserDTO;
import com.ijse.demo.entity.User;
import com.ijse.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getUser")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/getUserById/{id}")
    public UserDTO getUserByUserId(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserByNameAndAddress")
    public UserDTO getUserByUserIdAndName(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address") String address){
        System.out.println("UserName : "+name+" address : "+address);

        return userService.getUserByNameAndAddress(name, address);

    }

}
