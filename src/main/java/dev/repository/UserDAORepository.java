package dev.repository;

import dev.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAORepository extends JpaRepository<UserDAO,Long> {
    UserDAO findByName(String name);
}
