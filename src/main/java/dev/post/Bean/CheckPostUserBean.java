package dev.post.Bean;

import dev.post.Repository.PostDAORepository;
import dev.post.domain.DTO.CheckPostUserDTO;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckPostUserBean{
    private final PostDAORepository postDAORepository;

    public CheckPostUserBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }

    public Boolean exec(CheckPostUserDTO checkPostUserDTO){
        PostDAO postDAO = postDAORepository.findByUserId(checkPostUserDTO.getId());

        if(postDAO.getUserId() == checkPostUserDTO.getId()) return true;
        else return false;
    }
}
