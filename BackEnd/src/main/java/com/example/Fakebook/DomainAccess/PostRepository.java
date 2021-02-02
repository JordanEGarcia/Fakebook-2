package com.example.Fakebook.DomainAccess;

import com.example.Fakebook.Models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {

    @Query("Select p from Posts p where p.userId=?1")
    Optional<PostModel> posts (long userId);
}
