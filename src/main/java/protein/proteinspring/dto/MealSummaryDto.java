package protein.proteinspring.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.entity.Meal;
import protein.proteinspring.entity.Product;

@Getter
@RequiredArgsConstructor
public class MealSummaryDto {
    private final Double calories;
    private final Double protein;
    private final Double carbohydrate;
    private final Double fat;

    public static MealSummaryDto fromTodayMeals(List<Meal> todayMeals) {
        List<Product> products = todayMeals.stream().map(Meal::getProduct).collect(Collectors.toList());

        return new MealSummaryDto(
                products.stream().mapToDouble(Product::getCalories).sum(),
                products.stream().mapToDouble(Product::getProtein).sum(),
                products.stream().mapToDouble(Product::getTotalCarbohydrate).sum(),
                products.stream().mapToDouble(Product::getTotalFat).sum()
        );
    }
}
