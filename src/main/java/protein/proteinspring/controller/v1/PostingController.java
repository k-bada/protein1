package protein.proteinspring.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import protein.proteinspring.dto.PostingDto;
import protein.proteinspring.dto.PostingLogDto;
import protein.proteinspring.dto.PostingRequestDto;
import protein.proteinspring.dto.ResponseDto;
import protein.proteinspring.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Posting", description = "커뮤니티 글 관련 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/posting")
@RestController
public class PostingController {
    private final PostingService postingService;

    @Operation(summary = "글 추가", description = "커뮤니티에 글을 작성합니다.")
    @PostMapping("/posts/edit")
    public ResponseDto<PostingDto> addPost(@Valid @RequestBody PostingRequestDto requestDto) {
        return ResponseDto.of(postingService.addPost(requestDto));
    }

    @Operation(summary = "전체 포스팅", description = "커뮤니티에 작성된 모든 사용자의 글을 불러옵니다.")
    @GetMapping("/posts")
    public ResponseDto<List<PostingLogDto>> findPost() {
        return ResponseDto.of(postingService.findPost());
    }
}
