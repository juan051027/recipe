package dev.user.Bean;

import dev.user.repository.UserDAORepository;
import org.springframework.stereotype.Component;

@Component
public class LogoutUserBean {
    private final UserDAORepository userDAORepository;

    public LogoutUserBean(UserDAORepository userDAORepository){
        this.userDAORepository = userDAORepository;
    }

    public Boolean exec(){
        return true;
    }
}
