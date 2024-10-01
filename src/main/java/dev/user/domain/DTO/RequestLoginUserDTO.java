package dev.user.domain.DTO;

import lombok.Data;


@Data
public class RequestLoginUserDTO {
    private String userName;
    private String passWord;
}
