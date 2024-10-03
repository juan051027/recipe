package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.RequestDeletePostDTO;
import dev.post.domain.PostDAO;

public class DeletePostBean {
    private final PostDAORepository postDAORepository;

    public DeletePostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public Boolean exec(RequestDeletePostDTO requestDeletePostDTO){
        PostDAO postDAO = postDAORepository.findById(requestDeletePostDTO.getRecipeId()).get();
        if(postDAO.getRecipeId() == null) return false;
        postDAORepository.deleteById(requestDeletePostDTO.getRecipeId());
        return true;
    }
}
