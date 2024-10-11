package dev.post.service;

import dev.post.Bean.*;
import dev.post.domain.DTO.*;
import dev.post.domain.PostDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    private final SavePostBean savePostBean;
    private final UpdatePostBean updatePostBean;
    private final DeletePostBean deletePostBean;
    private final GetPostAllBean getPostAllBean;
    private final GetPostByPostIdBean getPostByPostIdBean;
    private final GetPostAllByUserIdBean getPostAllByUserIdBean;

    public PostService(SavePostBean savePostBean,
                       UpdatePostBean updatePostBean,
                       DeletePostBean deletePostBean,
                       GetPostAllBean getPostAllBean,
                       GetPostByPostIdBean getPostByPostIdBean,
                       GetPostAllByUserIdBean getPostAllByUserIdBean){
        this.savePostBean = savePostBean;
        this.updatePostBean = updatePostBean;
        this.deletePostBean = deletePostBean;
        this.getPostAllBean = getPostAllBean;
        this.getPostByPostIdBean = getPostByPostIdBean;
        this.getPostAllByUserIdBean = getPostAllByUserIdBean;
    }

    public PostDAO savePost(RequestSavePostDTO requestSavePostDTO){
        return savePostBean.exec(requestSavePostDTO);
    }

    public Boolean modifyPost(RequestUpdatePostDTO requestUpdatePostDTO){
        return updatePostBean.exec(requestUpdatePostDTO);
    }

    public Boolean deletePost(RequestDeletePostDTO requestDeletePostDTO){
        return deletePostBean.exec(requestDeletePostDTO);
    }

    public List<PostDAO> findAllPost(){
        return getPostAllBean.exec();
    }

    public PostDAO findDetailPost(UUID recipeId){
        return getPostByPostIdBean.exec(recipeId);
    }

    public List<PostDAO> findUserPost(UUID userId){
        return getPostAllByUserIdBean.exec(userId);
    }
}
