package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.CheckPostUserDTO;
import dev.post.domain.DTO.RequestUpdatePostDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostBean {
    private final PostDAORepository postDAORepository;
    private final CheckPostUserBean checkPostUserBean;

    public UpdatePostBean(PostDAORepository postDAORepository, CheckPostUserBean checkPostUserBean){
        this.postDAORepository = postDAORepository;
        this.checkPostUserBean = checkPostUserBean;
    }

    public Boolean exec(RequestUpdatePostDTO requestUpdatePostDTO){
       PostDAO postDAO = postDAORepository.findByRecipeIdAndUserId(requestUpdatePostDTO.getRecipeId(), requestUpdatePostDTO.getUserId());

       CheckPostUserDTO checkPostUserDTO = new CheckPostUserDTO();
       checkPostUserDTO.setId(requestUpdatePostDTO.getRecipeId());

       if(postDAO == null) return false;
       if(!checkPostUserBean.exec(checkPostUserDTO)) return false;

       postDAO.setThumbnail(requestUpdatePostDTO.getThumbnail());
       postDAO.setTitle(requestUpdatePostDTO.getTitle());
       postDAO.setDescription(requestUpdatePostDTO.getDescription());
       postDAO.setIngredient(requestUpdatePostDTO.getIngredient());
       postDAO.setInstructions(requestUpdatePostDTO.getInstructions());

       postDAORepository.save(postDAO);

       return true;
    }
}
