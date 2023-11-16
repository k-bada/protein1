package protein.proteinspring.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@RequiredArgsConstructor
public enum MealType {
    BREAKFAST(LocalTime.of(6, 0), LocalTime.of(8, 30)),
    LUNCH(LocalTime.of(12, 0), LocalTime.of(14, 30)),
    DINNER(LocalTime.of(17, 0), LocalTime.of(19, 30)),
    SNACK(null, null);

    private final LocalTime startTime;
    private final LocalTime endTime;
}
