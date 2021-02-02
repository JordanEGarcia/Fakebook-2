package com.example.Fakebook.Services;

import com.example.Fakebook.DomainAccess.UserRepository;
import com.example.Fakebook.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getUsers() {
       return userRepository.findAll();
    }
    public Optional<UserModel> getUserById(long id) {
        return userRepository.findById(id);
    }

    public void addNewUser(UserModel user) {
        Optional<UserModel> userByUsername = userRepository.findUserByUsername(user.getUsername());

        if (userByUsername.isPresent()) {
            throw new IllegalStateException("UserName Taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        boolean exists = userRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("User With that Id does not exist.");
        }
        userRepository.deleteById(id);
    }
    @Transactional
    public void editUser(long userid, String firstName, String email) {
        UserModel userEntity = userRepository.findById(userid)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));

        userEntity.setFirstName(firstName);
        userEntity.setEmail(email);
    }
}
