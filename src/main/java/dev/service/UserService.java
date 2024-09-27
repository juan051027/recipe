package dev.service;


import dev.Bean.LoginUserBean;
import dev.Bean.LogoutUserBean;
import dev.Bean.SameUserBean;
import dev.Bean.SaveUserBean;
import dev.domain.DTO.RequestCheckUserDTO;
import dev.domain.DTO.RequestLoginUserDTO;
import dev.domain.DTO.RequestSaveUserDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public  class  UserService {
    private final SaveUserBean saveUserBean;
    private final LoginUserBean loginUserBean;
    private final LogoutUserBean logoutUserBean;
    private final SameUserBean sameUserBean;

    public UserService(SaveUserBean saveUserBean,
                       LoginUserBean loginUserBean,
                       LogoutUserBean logoutUserBean,
                       SameUserBean sameUserBean) {
        this.saveUserBean = saveUserBean;
        this.loginUserBean = loginUserBean;
        this.logoutUserBean = logoutUserBean;
        this.sameUserBean = sameUserBean;
    }


    public Boolean saveUser(RequestSaveUserDTO requestSaveUserDTO){
        return saveUserBean.exec(requestSaveUserDTO);
    }

    public UUID loginUser(RequestLoginUserDTO requestLoginUserDTO){
        return loginUserBean.exec(requestLoginUserDTO);
    }

    public Boolean logoutUser(){
        return logoutUserBean.exec();
    }

    public Boolean checkUser(RequestCheckUserDTO requestCheckUserDTO){
        return sameUserBean.exec(requestCheckUserDTO);
    }
}
