package dev.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Getter
@Setter
@Entity
public class PostDAO {
    @Id
    private UUID recipeId;
    @Column(name = "user_id")
    private UUID userId;
    private String thumbnail;
    private String title;
    private String description;

    @ElementCollection
    @CollectionTable(name = "name", joinColumns = @JoinColumn(name = "quantity"))
    @MapKeyColumn
    private Map<String, Object> ingredient;
    private Map<String, Object> instructions;
}
