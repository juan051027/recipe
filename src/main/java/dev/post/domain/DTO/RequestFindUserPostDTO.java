package dev.post.domain.DTO;


import lombok.Data;

import java.util.UUID;

@Data
public class RequestFindUserPostDTO {
    private UUID user_id;
}
