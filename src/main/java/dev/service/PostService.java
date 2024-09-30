package dev.service;

import dev.Bean.SavePostBean;
import dev.domain.DTO.RequestSavePostDTO;
import dev.domain.PostDAO;
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
