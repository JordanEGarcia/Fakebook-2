package com.example.Fakebook.Controllers;

import com.example.Fakebook.Models.UserModel;
import com.example.Fakebook.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }
    @GetMapping(path = "{userId}")
    public Optional<UserModel> getUser(@PathVariable("userId") int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void CreateUser(@RequestBody UserModel user) {
        userService.addNewUser(user);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") int id) {
        userService.deleteUser(id);
    }
    @PutMapping(path="{userId}")
    public void editUser(
            @RequestBody UserModel user,
            @PathVariable("userId") int id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String email) {
        userService.editUser(id, firstName, email);
    }
}
