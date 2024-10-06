package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.CheckPostUserDTO;
import dev.post.domain.DTO.RequestDeletePostDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class DeletePostBean {
    private final PostDAORepository postDAORepository;
    private final CheckPostUserBean checkPostUserBean;

    public DeletePostBean(PostDAORepository postDAORepository, CheckPostUserBean checkPostUserBean){
        this.postDAORepository = postDAORepository;
        this.checkPostUserBean = checkPostUserBean;
    }

    public Boolean exec(RequestDeletePostDTO requestDeletePostDTO){
        PostDAO postDAO = postDAORepository.findById(requestDeletePostDTO.getRecipeId()).get();
        CheckPostUserDTO checkPostUserDTO = new CheckPostUserDTO();
        checkPostUserDTO.setId(postDAO.getRecipeId());

        if(postDAO.getRecipeId() == null) return false;
        if(!checkPostUserBean.exec(checkPostUserDTO)) return false;

        postDAORepository.deleteById(requestDeletePostDTO.getRecipeId());
        return true;
    }
}
