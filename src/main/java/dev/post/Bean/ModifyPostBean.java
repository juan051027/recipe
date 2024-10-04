package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.RequestModifyPostDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class ModifyPostBean {
    private final PostDAORepository postDAORepository;

    public ModifyPostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public Boolean exec(RequestModifyPostDTO requestModifyPostDTO){
       PostDAO postDAO = postDAORepository.findByRecipeIdAndUserId(requestModifyPostDTO.getRecipeId(),requestModifyPostDTO.getUserId());
       if(postDAO == null) return false;
       postDAO.setThumbnail(requestModifyPostDTO.getThumbnail());
       postDAO.setTitle(requestModifyPostDTO.getTitle());
       postDAO.setDescription(requestModifyPostDTO.getDescription());
       postDAO.setIngredient(requestModifyPostDTO.getIngredient());
       postDAO.setInstructions(requestModifyPostDTO.getInstructions());
       postDAORepository.save(postDAO);
       return true;
    }
}
