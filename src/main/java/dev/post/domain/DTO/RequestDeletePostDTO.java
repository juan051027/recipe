package dev.post.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestDeletePostDTO {
    private UUID recipeId;
}
