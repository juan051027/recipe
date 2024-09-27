package dev.Bean;

import dev.domain.DTO.RequestCheckUserDTO;
import dev.domain.UserDAO;
import dev.repository.UserDAORepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SameUserBean {

    private final UserDAORepository userDAORepository;

    public SameUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

    public Boolean exec(RequestCheckUserDTO requestCheckUserDTO){
        UserDAO userDAO = userDAORepository.findByUserName(requestCheckUserDTO.getUserName());
        return Objects.equals(userDAO.getUserName(), requestCheckUserDTO.getUserName());
    }


}
