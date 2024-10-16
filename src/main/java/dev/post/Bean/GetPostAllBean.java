package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetPostAllBean {
    private final PostDAORepository postDAORepository;

    public GetPostAllBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public List<PostDAO> exec(){
        return postDAORepository.findAll();
    }
}
