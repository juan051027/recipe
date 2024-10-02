package dev.post.Repository;

import dev.post.domain.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostDAORepository extends JpaRepository<PostDAO, UUID> {
    PostDAO findByTitle(String title);
    PostDAO findByRecipeIdAndUserId(UUID recipeid, UUID userid);
}