package com.codejava.InventoryApp.repository;

import com.codejava.InventoryApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);
}
