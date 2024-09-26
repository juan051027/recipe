package dev.domain.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class RequestLogoutUserDTO {
    private String userName;
    private String passWord;
}
