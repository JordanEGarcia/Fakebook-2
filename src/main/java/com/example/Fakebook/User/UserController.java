package com.example.Fakebook.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    @GetMapping
    public List<UserModel> hello() {
        UserModel jordan =
                new UserModel(1,"jordang", "Jordan", "Garcia", "jordangarcia@gmail.com", LocalDate.of(1996, Month.JULY, 12));
        return List.of(jordan);
    }
}
