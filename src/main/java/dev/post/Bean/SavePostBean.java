package dev.post.Bean;

import dev.post.domain.PostDAO;
import dev.post.domain.DTO.RequestSavePostDTO;
import dev.post.Repository.PostDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SavePostBean {
    private final PostDAORepository postDAORepository;

    public SavePostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public PostDAO exec(RequestSavePostDTO requestSavePostDTO){
        PostDAO postDAO = new PostDAO();
        postDAO.setRecipeId(UUID.randomUUID());
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
