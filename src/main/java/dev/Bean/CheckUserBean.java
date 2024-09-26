package dev.Bean;

import dev.domain.UserDAO;
import dev.repository.UserDAORepository;
import org.springframework.stereotype.Component;

@Component
public class CheckUserBean {

    private final UserDAORepository userDAORepository;

    public CheckUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

}
