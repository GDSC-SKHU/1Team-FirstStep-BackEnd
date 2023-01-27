package gdsc.com.firststep.post.controller;

import gdsc.com.firststep.post.dto.PostsListResponseDto;
import gdsc.com.firststep.post.dto.PostsResponseDto;
import gdsc.com.firststep.post.dto.PostsSaveRequestDto;
import gdsc.com.firststep.post.dto.PostsUpdateRequestDto;
import gdsc.com.firststep.post.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // 게시글 생성
    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
    // 게시글 전체 조회
    @GetMapping("api/posts")
    public ResponseEntity<List<PostsListResponseDto>> findAllDesc() {
        List<PostsListResponseDto> response = postsService.findAllDesc();

        if (response.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }
        return ResponseEntity.ok(response);
    }
    // 특정 게시글 조회
    @GetMapping("/api/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
    // 게시글 수정
    @PostMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}