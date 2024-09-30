package dev.repository;

import dev.domain.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostDAORepository extends JpaRepository<PostDAO, UUID> {
    PostDAO findByUserId(UUID userid);
    PostDAO findByTitle(String title);
}
