package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPostByPostIdBean {
    private final PostDAORepository postDAORepository;

    public GetPostByPostIdBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public PostDAO exec(UUID postId){
        PostDAO postDAO = postDAORepository.findById(postId).get();
        return postDAO;
    }

}
