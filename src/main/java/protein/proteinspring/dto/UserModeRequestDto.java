package protein.proteinspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.enums.ModeType;


@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UserModeRequestDto {
    private final ModeType mode;
}
