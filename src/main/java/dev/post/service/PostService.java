package dev.post.service;

import dev.post.domain.PostDAO;
import dev.post.Bean.SavePostBean;
import dev.post.domain.DTO.RequestSavePostDTO;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final SavePostBean savePostBean;

    public PostService(SavePostBean savePostBean){
        this.savePostBean = savePostBean;
    }

    public PostDAO savePost(RequestSavePostDTO requestSavePostDTO){
        return savePostBean.exec(requestSavePostDTO);
    }
}
