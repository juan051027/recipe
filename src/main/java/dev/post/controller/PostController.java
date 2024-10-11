package dev.post.controller;

import dev.post.domain.DTO.*;
import dev.post.domain.PostDAO;
import dev.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/recipes")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //레시피 게시
    @PostMapping
    public ResponseEntity<Map<String, Object>> postpost(@RequestBody RequestSavePostDTO requestSavePostDTO){
        UUID id = postService.savePost(requestSavePostDTO).getRecipeId();
        Boolean isSuccess = (id != null);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success",isSuccess);
        responseMap.put("message", isSuccess ? "레시피 등록에 성공했습니다." : "레시피 등록에 실패하였습니다.");
        responseMap.put("recipe_id", id);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    //레시피 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deletepost(@RequestBody RequestDeletePostDTO requestDeletePostDTO){
        Boolean isSuccess = postService.deletePost(requestDeletePostDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success",isSuccess);
        responseMap.put("message", isSuccess ? "레시피 삭제에 성공했습니다." : "레시피 삭제에 실패하였습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }


    //레시피 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> modifypost(@RequestBody RequestUpdatePostDTO requestUpdatePostDTO){
        Boolean isSuccess = postService.modifyPost(requestUpdatePostDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success",isSuccess);
        responseMap.put("message", isSuccess ? "레시피 수정에 성공했습니다." : "레시피 수정에 실패하였습니다.");
        if(isSuccess) responseMap.put("recipe_id", requestUpdatePostDTO.getRecipeId());
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }

    //레시피 전체 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findallpost(){
        List<PostDAO> postDAO = postService.findAllPost();
        Boolean isSuccess = (!postDAO.isEmpty());

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("isSuccess",isSuccess);
        responseMap.put("message",isSuccess ? postDAO : "레시피 조회에 실패하였습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }

    //레시피 id 조회
    @GetMapping("/detail/{recipeId}")
    public ResponseEntity<Map<String,Object>> finddetailpost(@PathVariable("recipeId") UUID postId){

        PostDAO postDAO = postService.findDetailPost(postId);
        Boolean isSuccess = (postDAO != null);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("isSuccess",isSuccess);
        responseMap.put("message",isSuccess ? postDAO : "레시피 조회에 실패하였습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // user id에 맞는 전체 게시물 조회
    @GetMapping("/detail/{userId}/all")
    public ResponseEntity<Map<String,Object>> finduserpost(@PathVariable("userId") UUID userId){

        List<PostDAO> postDAO = postService.findUserPost(userId);
        Boolean isSuccess = (!postDAO.isEmpty());

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("isSuccess",isSuccess);
        responseMap.put("message",isSuccess ? postDAO : "레시피 조회에 실패하였습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }


}
