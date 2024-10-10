package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.RequestFindUserPostDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FindUserPostBean {
    private final PostDAORepository postDAORepository;

    public FindUserPostBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }


    public List<PostDAO> exec(RequestFindUserPostDTO requestfindUserPostDTO){
        return postDAORepository.findAllByUserId(requestfindUserPostDTO.getUser_id());
    }


}
