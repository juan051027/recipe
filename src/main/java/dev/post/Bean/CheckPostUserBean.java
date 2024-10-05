package dev.post.Bean;

import dev.post.Repository.PostDAORepository;


public class CheckPostUserBean (){
    private final PostDAORepository postDAORepository;

    public CheckPostUserBean(PostDAORepository postDAORepository){
        this.postDAORepository = postDAORepository;
    }
}
