package dev.post.domain.DTO;

import dev.post.domain.StringListConverter;
import jakarta.persistence.Convert;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class RequestModifyPostDTO {
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
