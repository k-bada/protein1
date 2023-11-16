package protein.proteinspring.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import protein.proteinspring.enums.MealType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.entity.Meal;

@Getter
@RequiredArgsConstructor
public class MealLogDto {
    private final Long id;
    private final MealType type;
    private final String productName;
    private final Double calories;
    private final LocalDateTime mealTime;
    private final Boolean isHealthy;

    public static MealLogDto fromEntity(Meal meal) {
        Boolean isHealthy;
        if(meal.getType() == MealType.SNACK) {
            isHealthy = true;
        }else {
            isHealthy = meal.getMealDateTime().toLocalTime().isAfter(meal.getType().getStartTime().minusSeconds(1))
                    && meal.getMealDateTime().toLocalTime().isBefore(meal.getType().getEndTime().plusSeconds(1));
        }
        return new MealLogDto(
                meal.getId(),
                meal.getType(),
                meal.getProduct().getName(),
                meal.getProduct().getCalories(),
                meal.getMealDateTime(),
                isHealthy
        );
    }
}
