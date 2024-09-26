package dev.controller;


import dev.domain.DTO.RequestSaveUserDTO;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

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

}
