package com.example.Fakebook.Services;

import com.example.Fakebook.Models.UserModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {
    public List<UserModel> getUser() {
        UserModel jordan =
                new UserModel(1,"jordang", "Jordan", "Garcia", "jordangarcia@gmail.com", LocalDate.of(1996, Month.JULY, 12));
        return List.of(jordan);
    }
}
