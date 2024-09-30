package dev.domain.DTO;

import lombok.Data;


import java.util.UUID;


@Data
public class RequestLoginUserDTO {
    private String userName;
    private String passWord;
}
