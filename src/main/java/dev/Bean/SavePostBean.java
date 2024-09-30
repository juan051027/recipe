package dev.Bean;

import dev.domain.DTO.RequestSavePostDTO;
import dev.domain.UserDAO;
import dev.repository.PostDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SavePostBean {
    private final PostDAORepository postDAORepository;

    public SavePostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public RequestSavePostDTO exec(RequestSavePostDTO requestSavePostDTO){
        UserDAO userDAO = new UserDAO();
        requestSavePostDTO.setUserId(UUID.randomUUID());

    }
}
