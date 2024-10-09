package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.RequestFindDetailPostDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class FindDetailPostBean {
    private final PostDAORepository postDAORepository;

    public FindDetailPostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public PostDAO exec(RequestFindDetailPostDTO requestFindDetailPostDTO){
        PostDAO postDAO = postDAORepository.findById(requestFindDetailPostDTO.getRecipe_id()).get();

        return postDAO;
    }

}
