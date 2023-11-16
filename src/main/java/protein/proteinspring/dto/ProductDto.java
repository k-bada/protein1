package protein.proteinspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.entity.Product;

@Getter
@RequiredArgsConstructor
public class ProductDto {
    private final Long productId;
    private final String productName;
    private final String brandName;
    private final Double calories; // 칼로리
    private final Double protein; // 프로틴
    private final Double totalCarbohydrate; //탄수화물
    private final Double sugars; // 당
    private final Double totalFat; // 지방
    private final Double saturatedFat; // 포화지방
    private final Double transFat; // 트랜스지방
    private final Double sodium; // 나트륨
    private final Double cholesterol; // 콜레스테롤

    public static ProductDto fromEntity(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getBrandName(),
                product.getCalories(),
                product.getProtein(),
                product.getTotalCarbohydrate(),
                product.getSugars(),
                product.getTotalFat(),
                product.getSaturatedFat(),
                product.getTransFat(),
                product.getSodium(),
                product.getCholesterol()
        );
    }
}
