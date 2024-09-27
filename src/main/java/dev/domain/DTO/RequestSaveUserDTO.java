package dev.domain.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RequestSaveUserDTO {
    private String userName;
    private String passWord;
}
