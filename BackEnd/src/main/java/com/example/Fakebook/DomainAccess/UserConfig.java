package com.example.Fakebook.DomainAccess;

import com.example.Fakebook.Models.PostModel;
import com.example.Fakebook.Models.UserModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            UserModel jordan = new UserModel("jordang", "Jordan", "Garcia", "jordangarcia@gmail.com", LocalDate.of(1996, Month.JULY, 12), "https://i.pinimg.com/originals/36/60/58/366058cd421e6a981e50c6f800abbbd0.png");
            UserModel Jade   = new UserModel("xxJadenxx", "Jaden", "Johnson", "jadeJohnson@gmail.com", LocalDate.of(2001, Month.FEBRUARY, 10), "https://www.writeups.org/wp-content/uploads/Robin-Teen-Titans-animated-series.jpg");
            PostModel post1 = new PostModel(1, "Going to save the world, one line at a time");
            PostModel post2 = new PostModel(2, "I can help save the world too!");
            repository.saveAll(List.of(jordan,Jade));
        };
    }

}
