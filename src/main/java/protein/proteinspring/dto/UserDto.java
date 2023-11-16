package protein.proteinspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.entity.User;
import protein.proteinspring.enums.GenderType;
import protein.proteinspring.enums.ModeType;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class UserDto {
    private final String name;
    private final Double height;
    private final Double weight;
    private final Double goalWeight;
    private final GenderType genderType;
    private final LocalDate birthDate;
    private final ModeType mode;

    private final Integer recommendCalories;
    private final Integer recommendTotalCarbohydrate;
    private final Integer recommendProtein;
    private final Integer recommendTotalFat;

    public static UserDto fromEntity(User user) {
        return new UserDto(
                user.getName(),
                user.getHeight(),
                user.getWeight(),
                user.getGoalWeight(),
                user.getGender(),
                user.getBirthDate(),
                user.getMode(),
                user.getMode().getRecommendCalories(),
                user.getMode().getRecommendTotalCarbohydrate(),
                user.getMode().getRecommendProtein(),
                user.getMode().getRecommendTotalFat()
        );
    }
}
