package protein.proteinspring.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import protein.proteinspring.enums.MealType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class MealLogRequestDto {
    @NotNull
    private final Long userId;
    @NotNull
    private final Long productId;
    @NotNull
    private final MealType mealType;
    @NotNull
    private final LocalDateTime mealDateTime;
}
