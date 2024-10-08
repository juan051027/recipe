package dev.user.controller;


import dev.user.domain.DTO.RequestCheckUserDTO;
import dev.user.domain.DTO.RequestLoginUserDTO;
import dev.user.domain.DTO.RequestSaveUserDTO;
import dev.user.service.UserService;
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


    //중복 검사
    @PostMapping("/duplicate")
    public ResponseEntity<Map<String, Object>> checkname(@RequestBody RequestCheckUserDTO requestCheckUserDTO){
        Boolean isSuccess = userService.checkUser(requestCheckUserDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success", isSuccess);
        responseMap.put("message", isSuccess ? "이미 있는 아이디입니다." : "사용할 수 있는 아이디입니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody RequestSaveUserDTO requestSaveUserDTO){
        Boolean isSuccess = userService.saveUser(requestSaveUserDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("username", requestSaveUserDTO.getUserName());
        responseMap.put("is_success",isSuccess);
        responseMap.put("message", isSuccess ? "계정이 성공적으로 생성되었습니다." : "비밀번호가 보안 기준에 적합하지 않습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }



    //로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody RequestLoginUserDTO requestLoginUserDTO){
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
