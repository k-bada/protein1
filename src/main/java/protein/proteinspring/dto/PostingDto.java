package protein.proteinspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.entity.Posting;

@Getter
@RequiredArgsConstructor
public class PostingDto {
    private final Long userId;
    private final Long PostId;

    public static PostingDto fromEntity(Posting posting) {
        return new PostingDto(
                posting.getUser().getId(),
                posting.getId()
        );
    }
}
