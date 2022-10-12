package com.bookshop.bookshop.repositories;

import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

}
