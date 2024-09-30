package dev.Bean;

import dev.domain.DTO.RequestSavePostDTO;
import dev.domain.PostDAO;
import dev.domain.UserDAO;
import dev.repository.PostDAORepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class SavePostBean {
    private final PostDAORepository postDAORepository;

    public SavePostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public RequestSavePostDTO exec(RequestSavePostDTO requestSavePostDTO){
        PostDAO postDAO = new PostDAO();
        postDAO.setUserId(requestSavePostDTO.getUserId());
        postDAO.setThumbnail(requestSavePostDTO.getThumbnail());
        postDAO.setTitle(requestSavePostDTO.getTitle());
        postDAO.setDescription(requestSavePostDTO.getDescription());
        postDAO.setIngredient(requestSavePostDTO.getIngredient());
        postDAO.setInstructions(requestSavePostDTO.getInstructions());
        postDAORepository.save(postDAO);
        return postDAO;


    }
}
