package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.FindUserPostDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class FindUserPostBean {
    private final PostDAORepository postDAORepository;

    public FindUserPostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    /*
    public List<PostDAO> exec(FindUserPostDTO findUserPostDTO){
        PostDAO postDAO = postDAORepository.findAllById(findUserPostDTO.getUserid());
        return postDAO;
    }
    */

}
