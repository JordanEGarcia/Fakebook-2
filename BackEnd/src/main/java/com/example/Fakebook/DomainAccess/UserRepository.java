package com.example.Fakebook.DomainAccess;

import com.example.Fakebook.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("Select s From User s Where s.Username = ?1")
    Optional<UserModel> findUserByUsername(String username);


}
