package dev.Bean;

import dev.domain.RequestSaveUserDTO;
import dev.domain.UserDAO;
import dev.repository.UserDAORepository;
import dev.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.UUID;

@Configuration
public class SaveUserBean {
    private final UserDAORepository userDAORepository;

    public SaveUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

    @Bean
    public Boolean exec(RequestSaveUserDTO requestSaveUserDTO){
        UserDAO userDAO = new UserDAO();
        userDAO.setId(UUID.randomUUID());
        userDAO.setUserName(requestSaveUserDTO.getName());
        userDAO.setPassWord(requestSaveUserDTO.getPassword());
        userDAORepository.save(userDAO);
        return true;
    }
}
