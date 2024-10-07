package dev.post.service;

import dev.post.Bean.DeletePostBean;
import dev.post.Bean.FindAllPostBean;
import dev.post.Bean.ModifyPostBean;
import dev.post.domain.DTO.RequestDeletePostDTO;
import dev.post.domain.DTO.RequestModifyPostDTO;
import dev.post.domain.PostDAO;
import dev.post.Bean.SavePostBean;
import dev.post.domain.DTO.RequestSavePostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final SavePostBean savePostBean;
    private final ModifyPostBean modifyPostBean;
    private final DeletePostBean deletePostBean;
    private final FindAllPostBean findAllPostBean;

    public PostService(SavePostBean savePostBean,
                       ModifyPostBean modifyPostBean,
                       DeletePostBean deletePostBean,
                       FindAllPostBean findAllPostBean){
        this.savePostBean = savePostBean;
        this.modifyPostBean = modifyPostBean;
        this.deletePostBean = deletePostBean;
        this.findAllPostBean = findAllPostBean;
    }


    public PostDAO savePost(RequestSavePostDTO requestSavePostDTO){
        return savePostBean.exec(requestSavePostDTO);
    }


    public Boolean modifyPost(RequestModifyPostDTO requestModifyPostDTO){
        return modifyPostBean.exec(requestModifyPostDTO);
    }


    public Boolean deletePost(RequestDeletePostDTO requestDeletePostDTO){
        return deletePostBean.exec(requestDeletePostDTO);
    }

    public List<PostDAO> FindAllPost(){
        return findAllPostBean.exec();
    }
}
