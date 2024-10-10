package dev.post.controller;

import dev.post.domain.DTO.*;
import dev.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<Map<String, Object>> modifypost(@RequestBody RequestModifyPostDTO requestModifyPostDTO){
        Boolean isSuccess = postService.modifyPost(requestModifyPostDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success",isSuccess);
        responseMap.put("message", isSuccess ? "레시피 수정에 성공했습니다." : "레시피 수정에 실패하였습니다.");
        if(isSuccess) responseMap.put("recipe_id",requestModifyPostDTO.getRecipeId());
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }

    //레시피 전체 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findallpost(){

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("posts",postService.findAllPost());
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);

    }

    //레시피 id 조회
    @GetMapping("/detail/{recipe_id}")
    public ResponseEntity<Map<String,Object>> finddetailpost(@PathVariable("recipe_id") UUID postId){
        RequestFindDetailPostDTO requestFindDetailPostDTO = new RequestFindDetailPostDTO();
        requestFindDetailPostDTO.setRecipe_id(postId);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("post",postService.findDetailPost(requestFindDetailPostDTO));
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // user id에 맞는 전체 게시물 조회
    @GetMapping("/detail/{user_id}/all")
    public ResponseEntity<Map<String,Object>> finduserpost(@PathVariable("user_id") UUID userId){
        RequestFindUserPostDTO requestFindUserPostDTO = new RequestFindUserPostDTO();
        requestFindUserPostDTO.setUser_id(userId);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("posts",postService.findUserPost(requestFindUserPostDTO));
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }


}
