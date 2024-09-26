package dev.Bean;

import dev.domain.DTO.RequestLoginUserDTO;
import dev.domain.UserDAO;
import dev.repository.UserDAORepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class LoginUserBean {
    private final UserDAORepository userDAORepository;

    public LoginUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

    public UUID exec(RequestLoginUserDTO requestLoginUserDTO){
        UserDAO userDAO = userDAORepository.findById(requestLoginUserDTO.getId()).orElse(null);
        if(Objects.equals(userDAO.getUserName(), requestLoginUserDTO.getUserName()) && Objects.equals(userDAO.getPassWord(), requestLoginUserDTO.getPassWord())){
            return userDAO.getId();
        }
        else return null;
    }

}
