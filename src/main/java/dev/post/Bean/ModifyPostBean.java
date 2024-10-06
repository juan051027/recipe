package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.CheckPostUserDTO;
import dev.post.domain.DTO.RequestModifyPostDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class ModifyPostBean {
    private final PostDAORepository postDAORepository;
    private final CheckPostUserBean checkPostUserBean;

    public ModifyPostBean(PostDAORepository postDAORepository, CheckPostUserBean checkPostUserBean){
        this.postDAORepository = postDAORepository;
        this.checkPostUserBean = checkPostUserBean;
    }

    public Boolean exec(RequestModifyPostDTO requestModifyPostDTO){
       PostDAO postDAO = postDAORepository.findByRecipeIdAndUserId(requestModifyPostDTO.getRecipeId(),requestModifyPostDTO.getUserId());

       CheckPostUserDTO checkPostUserDTO = new CheckPostUserDTO();
       checkPostUserDTO.setId(requestModifyPostDTO.getRecipeId());

       if(postDAO == null) return false;
       if(!checkPostUserBean.exec(checkPostUserDTO)) return false;

       postDAO.setThumbnail(requestModifyPostDTO.getThumbnail());
       postDAO.setTitle(requestModifyPostDTO.getTitle());
       postDAO.setDescription(requestModifyPostDTO.getDescription());
       postDAO.setIngredient(requestModifyPostDTO.getIngredient());
       postDAO.setInstructions(requestModifyPostDTO.getInstructions());

       postDAORepository.save(postDAO);

       return true;
    }
}
