package dev.domain.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class RequestLoginUserDTO {
    private UUID id;
    private String userName;
    private String passWord;
}
