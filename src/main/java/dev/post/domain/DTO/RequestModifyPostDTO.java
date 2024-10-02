package dev.post.domain.DTO;

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
    private List<Map<String, Object>> ingredient;
    private List<Map<String, Object>> instructions;
}
