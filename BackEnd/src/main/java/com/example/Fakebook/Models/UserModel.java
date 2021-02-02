package com.example.Fakebook.Models;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")

@Entity(name="User")
@Table
public class UserModel {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long Id;
    @Column(
            updatable = false,
            nullable = false,
            unique = true
    )
    private String Username;
    @Column(
            nullable = false
    )
    private String FirstName;
    private String LastName;
    @Column(
            updatable = false,
            nullable = false,
            unique = true
    )
    private String Email;
    private LocalDate BirthDate;
    private String ProfilePicture;
    @OneToMany()
    @JoinColumn(name="UserId", referencedColumnName = "Id")
    private List<PostModel> Posts = new ArrayList<>();
    @Transient
    private Integer age;


    public UserModel() { } //

    public UserModel(long id, String username, String firstName, String lastName, String email, LocalDate birthDate, String profilePicture) {
        Id = id;
        Username = username;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        BirthDate = birthDate;
        ProfilePicture = profilePicture;
    }

    public UserModel(String username, String firstName, String lastName, String email, LocalDate birthDate, String profilePicture) {
        Username = username;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        BirthDate = birthDate;
        ProfilePicture = profilePicture;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
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
    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }

    public Integer getAge() {
        if(this.BirthDate==null)
            return 0;
        return Period.between(this.BirthDate, LocalDate.now()).getYears();
    }
}
