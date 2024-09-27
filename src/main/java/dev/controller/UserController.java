package dev.controller;


import dev.domain.DTO.RequestCheckUserDTO;
import dev.domain.DTO.RequestLoginUserDTO;
import dev.domain.DTO.RequestSaveUserDTO;
import dev.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/duplicate")
    public ResponseEntity<Map<String, Object>> checkname(RequestCheckUserDTO requestCheckUserDTO){
        Boolean isSuccess = userService.checkUser(requestCheckUserDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success", isSuccess);
        responseMap.put("message", isSuccess ? "사용할 수 있는 아이디입니다." : "이미 있는 아이디입니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }



    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(RequestSaveUserDTO requestSaveUserDTO){
        Boolean isSuccess = userService.saveUser(requestSaveUserDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success",isSuccess);
        responseMap.put("message", isSuccess ? "계정이 성공적으로 생성되었습니다." : "비밀번호가 보안 기준에 적합하지 않습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }




    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(RequestLoginUserDTO requestLoginUserDTO){
        UUID id = userService.loginUser(requestLoginUserDTO);
        Boolean isSuccess = id != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success", isSuccess);
        responseMap.put("message", isSuccess ? "로그인에 성공했습니다." : "아이디 혹은 비밀번호가 틀렸습니다.");
        responseMap.put("user_Id",id);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }




    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout() {
        Boolean isSuccess = true;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success", isSuccess);
        responseMap.put("message", isSuccess ? "로그아웃 성공했습니다." : "로그아웃에 실패했습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }


}
