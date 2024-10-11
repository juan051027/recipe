package dev.post.Repository;

import dev.post.domain.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostDAORepository extends JpaRepository<PostDAO, UUID> {
    PostDAO findByUserId(UUID userid);
    PostDAO findByRecipeIdAndUserId(UUID recipeid, UUID userid);
    List<PostDAO> findAllByUserId(UUID userid);
}