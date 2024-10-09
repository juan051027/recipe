package dev.post.service;

import dev.post.Bean.*;
import dev.post.domain.DTO.*;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final SavePostBean savePostBean;
    private final ModifyPostBean modifyPostBean;
    private final DeletePostBean deletePostBean;
    private final FindAllPostBean findAllPostBean;
    private final FindDetailPostBean findDetailPostBean;
    private final FindUserPostBean findUserPostBean;

    public PostService(SavePostBean savePostBean,
                       ModifyPostBean modifyPostBean,
                       DeletePostBean deletePostBean,
                       FindAllPostBean findAllPostBean,
                       FindDetailPostBean findDetailPostBean,
                       FindUserPostBean findUserPostBean){
        this.savePostBean = savePostBean;
        this.modifyPostBean = modifyPostBean;
        this.deletePostBean = deletePostBean;
        this.findAllPostBean = findAllPostBean;
        this.findDetailPostBean = findDetailPostBean;
        this.findUserPostBean = findUserPostBean;
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

    public List<PostDAO> findAllPost(){
        return findAllPostBean.exec();
    }

    public PostDAO findDetailPost(RequestFindDetailPostDTO requestFindDetailPostDTO){
        return findDetailPostBean.exec(requestFindDetailPostDTO);
    }

    public PostDAO findUserPost(RequestFindUserPostDTO requestFindUserPostDTO){
        return findUserPostBean.exec(requestFindUserPostDTO);
    }
}
