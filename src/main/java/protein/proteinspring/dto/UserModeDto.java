package protein.proteinspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import protein.proteinspring.entity.User;
import protein.proteinspring.enums.ModeType;

@Getter
@RequiredArgsConstructor
public class UserModeDto {
    private final Long id;
    private final ModeType mode;

    public static UserModeDto fromEntity(User user) {
        return new UserModeDto(
                user.getId(),
                user.getMode()
        );
    }
}
