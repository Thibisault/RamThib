//path: src/main/java/com/payfip/payfip/repository/UserRepository.java
package com.payfip.payfip.repository;

import com.payfip.payfip.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}