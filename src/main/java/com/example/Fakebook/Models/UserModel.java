package com.example.Fakebook.User;
import java.time.LocalDate;
@SuppressWarnings("FieldCanBeLocal")

public class UserModel {
    private int Id;
    private String Username;
    private String FirstName;
    private String LastName;
    private String Email;
    private LocalDate BirthDate;


    public UserModel() {
    }

    public UserModel(int id, String username, String firstName, String lastName, String email, LocalDate birthDate) {
        Id = id;
        Username = username;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        BirthDate = birthDate;
    }

    public UserModel(String username, String firstName, String lastName, String email, LocalDate birthDate) {
        Username = username;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        BirthDate = birthDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", BirthDate=" + BirthDate +
                '}';
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }
}
