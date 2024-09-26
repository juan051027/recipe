package dev.controller;


import dev.domain.DTO.RequestSaveUserDTO;
import dev.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    /*
    @PostMapping("/signup")
    public ResponseAPI saveUser(@RequestBody RequestSaveUserDTO requestSaveUserDTO){
        ResponseAPI responseAPI = new ResponseAPI();
        if(userService.saveUser(requestSaveUserDTO)){
            responseAPI.setIs_success(true);
            responseAPI.setMessage("계정이 성공적으로 생성되었습니다.");
        }
        else{
            responseAPI.setIs_success(false);
            responseAPI.setMessage("비밀번호가 보안 기준에 적합하지 않습니다.");
        }
        return responseAPI;
    }
    */
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout() {
        Boolean isSuccess = true;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", isSuccess);
        responseMap.put("message", isSuccess ? "로그아웃 성공했습니다." : "로그아웃에 실패했습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

}
