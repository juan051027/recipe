package dev.service;

import dev.Bean.SaveUserBean;
import dev.domain.RequestSaveUserDTO;
import dev.repository.UserDAORepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public  class  UserService {

    @Autowired
    Boolean saveUser(RequestSaveUserDTO requestSaveUserDTO){
        return SaveUserBean.exec(requestSaveUserDTO);
    }

}
