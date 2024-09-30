package dev.domain.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
public class RequestSavePostDTO {
    private UUID userId;
    private String thumbnail;
    private String title;
    private String description;
    private Map<String, Object> ingredient;
    private Map<String, Object> instructions;
    private LocalDateTime createdAt;
}
