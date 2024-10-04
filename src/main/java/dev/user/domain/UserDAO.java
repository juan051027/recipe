package dev.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
@Entity
public class UserDAO {

    @Id
    private UUID userId;
    private String userName;
    private String passWord;

}
