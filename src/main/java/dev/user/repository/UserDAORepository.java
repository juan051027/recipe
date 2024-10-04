package dev.user.repository;

import dev.user.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDAORepository extends JpaRepository<UserDAO, UUID> {
    UserDAO findByUserName(String username);


    UserDAO findByUserNameAndPassWord(String username, String password);
}
