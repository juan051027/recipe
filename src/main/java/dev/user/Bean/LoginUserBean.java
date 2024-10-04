package dev.user.Bean;

import dev.user.domain.DTO.RequestLoginUserDTO;
import dev.user.domain.UserDAO;
import dev.user.repository.UserDAORepository;
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
        UserDAO userDAO = userDAORepository.findByUserNameAndPassWord(requestLoginUserDTO.getUserName(),requestLoginUserDTO.getPassWord());
        if(Objects.equals(userDAO.getUserName(), requestLoginUserDTO.getUserName()) && Objects.equals(userDAO.getPassWord(), requestLoginUserDTO.getPassWord())){
            return userDAO.getUserId();
        }
        else return null;
    }

}
