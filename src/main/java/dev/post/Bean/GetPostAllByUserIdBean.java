package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
public class GetPostAllByUserIdBean {
    private final PostDAORepository postDAORepository;

    public GetPostAllByUserIdBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public List<PostDAO> exec(UUID userId){
        return postDAORepository.findAllByUserId(userId);
    }

}
