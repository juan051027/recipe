package dev.user.domain.DTO;

import lombok.Data;


@Data
public class RequestSaveUserDTO {
    private String userName;
    private String passWord;
}
