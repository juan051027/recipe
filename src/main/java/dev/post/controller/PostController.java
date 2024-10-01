package dev.post.controller;

import dev.post.service.PostService;
import dev.post.domain.DTO.RequestSavePostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin("*")
@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> signup(@RequestBody RequestSavePostDTO requestSavePostDTO){
        UUID id = postService.savePost(requestSavePostDTO).getRecipeId();
        Boolean isSuccess = (id != null);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("is_success",isSuccess);
        responseMap.put("message", isSuccess ? "레시피 등록에 성공했습니다." : "레시피 등록에 실패하였습니다.");
        responseMap.put("recipe_id", id);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

}
