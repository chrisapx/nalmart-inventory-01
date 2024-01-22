package com.cwift.cwiftMarketplace_backend.repository;

import com.cwift.cwiftMarketplace_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername ( String username );

    User findByUsernameOrEmailOrPhone ( String userNameOrEmailOrPhone, String userNameOrEmailOrPhone1, String userNameOrEmailOrPhone2 );
}
