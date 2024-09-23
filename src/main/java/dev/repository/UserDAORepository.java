package dev.repository;

import dev.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDAORepository extends JpaRepository<UserDAO, UUID> {
    UserDAO findByName(String name);
}
