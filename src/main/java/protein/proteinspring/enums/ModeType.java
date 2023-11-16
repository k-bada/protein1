package protein.proteinspring.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ModeType {
    NORMAL(1600, 160, 160, 35),
    DIET(1300, 130, 130, 28),
    BULK_UP(2000, 250, 150, 45);

    private final int recommendCalories;
    private final int recommendTotalCarbohydrate;
    private final int recommendProtein;
    private final int recommendTotalFat;
}
