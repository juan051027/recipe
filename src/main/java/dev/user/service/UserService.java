package dev.user.service;


import dev.user.Bean.CheckUserBean;
import dev.user.Bean.LoginUserBean;
import dev.user.Bean.LogoutUserBean;
import dev.user.Bean.SaveUserBean;
import dev.user.domain.DTO.RequestCheckUserDTO;
import dev.user.domain.DTO.RequestLoginUserDTO;
import dev.user.domain.DTO.RequestSaveUserDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public  class  UserService {
    private final SaveUserBean saveUserBean;
    private final LoginUserBean loginUserBean;
    private final LogoutUserBean logoutUserBean;
    private final CheckUserBean checkUserBean;

    public UserService(SaveUserBean saveUserBean,
                       LoginUserBean loginUserBean,
                       LogoutUserBean logoutUserBean,
                       CheckUserBean checkUserBean) {
        this.saveUserBean = saveUserBean;
        this.loginUserBean = loginUserBean;
        this.logoutUserBean = logoutUserBean;
        this.checkUserBean = checkUserBean;
    }

    //회원가입
    public Boolean saveUser(RequestSaveUserDTO requestSaveUserDTO){
        return saveUserBean.exec(requestSaveUserDTO);
    }

    //로그인
    public UUID loginUser(RequestLoginUserDTO requestLoginUserDTO){
        return loginUserBean.exec(requestLoginUserDTO);
    }

    //로그아웃
    public Boolean logoutUser(){
        return logoutUserBean.exec();
    }

    //중복검사
    public Boolean checkUser(RequestCheckUserDTO requestCheckUserDTO){
        return checkUserBean.exec(requestCheckUserDTO);
    }
}
