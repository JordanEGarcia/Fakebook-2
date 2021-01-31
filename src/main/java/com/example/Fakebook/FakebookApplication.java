package com.example.Fakebook;

import com.example.Fakebook.User.UserModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class FakebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakebookApplication.class, args);
	}

}
