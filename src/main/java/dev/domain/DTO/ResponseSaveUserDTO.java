package dev.domain.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Data
public class ResponseSaveUserDTO {
    private UUID id;
    private String name;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
