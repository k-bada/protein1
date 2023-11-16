package protein.proteinspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class MealMonthSummaryDto {
    private final List<LocalDate> fullMealDate;
}
