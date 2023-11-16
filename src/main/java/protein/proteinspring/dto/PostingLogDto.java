package protein.proteinspring.dto;

import protein.proteinspring.entity.Posting;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostingLogDto {
    private final Long userId;
    private final Long PostId;
    private final String content;
    private final LocalDateTime createDate;

    public static PostingLogDto fromEntity(Posting posting) {
        return new PostingLogDto(
                posting.getUser().getId(),
                posting.getId(),
                posting.getContent(),
                posting.getCreateDate()
        );
    }
}
