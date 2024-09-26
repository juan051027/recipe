package dev.Bean;

import dev.domain.DTO.RequestSaveUserDTO;
import dev.domain.UserDAO;
import dev.repository.UserDAORepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserBean {
    private final UserDAORepository userDAORepository;

    public SaveUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

    public Boolean exec(RequestSaveUserDTO requestSaveUserDTO){
        UserDAO userDAO = new UserDAO();
        userDAO.setId(UUID.randomUUID());
        userDAO.setUserName(requestSaveUserDTO.getName());
        userDAO.setPassWord(requestSaveUserDTO.getPassword());
        userDAORepository.save(userDAO);
        return true;
    }
}
