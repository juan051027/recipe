package dev.user.Bean;

import dev.user.domain.UserDAO;
import dev.user.domain.DTO.RequestSaveUserDTO;
import dev.user.repository.UserDAORepository;
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
        userDAO.setUserId(UUID.randomUUID());
        userDAO.setUserName(requestSaveUserDTO.getUserName());
        userDAO.setPassWord(requestSaveUserDTO.getPassWord());
        userDAORepository.save(userDAO);
        return true;
    }
}
