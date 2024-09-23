package dev.service;

import dev.Bean.SaveUserBean;
import dev.domain.DTO.RequestSaveUserDTO;
import org.springframework.stereotype.Service;

@Service
public  class  UserService {
    private final SaveUserBean saveUserBean;

    public UserService(SaveUserBean saveUserBean) {
        this.saveUserBean = saveUserBean;
    }

    public Boolean saveUser(RequestSaveUserDTO requestSaveUserDTO){
        return saveUserBean.exec(requestSaveUserDTO);
    }

}
