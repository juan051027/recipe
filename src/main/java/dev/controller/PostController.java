package dev.controller;

import dev.domain.DTO.RequestSavePostDTO;
import dev.domain.DTO.RequestSaveUserDTO;
import dev.domain.PostDAO;
import dev.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin("*")
@RestController
public class PostController {
    private final UserService userService;

    public PostController(UserService userService) {
        this.userService = userService;
    }
}
