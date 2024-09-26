package dev.Bean;

import dev.domain.DTO.RequestLogoutUserDTO;
import dev.domain.UserDAO;
import dev.repository.UserDAORepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LogoutUserBean {
    private final UserDAORepository userDAORepository;

    public LogoutUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

    public Boolean exec(RequestLogoutUserDTO requestLogoutUserDTO){
        UserDAO userDAO = userDAORepository.findByUserName(requestLogoutUserDTO.getUserName());
        return Objects.equals(userDAO.getPassWord(), requestLogoutUserDTO.getPassWord());
    }
}
