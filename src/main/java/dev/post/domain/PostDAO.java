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
    private UUID userId;
    private String thumbnail;
    private String title;
    private String description;

    @Convert(converter = StringListConverter.class)
    private List<Map<String, Object>> ingredient;

    @Convert(converter = StringListConverter.class)
    private List<Map<String, Object>> instructions;
}
