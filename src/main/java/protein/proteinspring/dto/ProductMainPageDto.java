package protein.proteinspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.entity.Product;

@Getter
@RequiredArgsConstructor
public class ProductMainPageDto {
    private final Long productId;
    private final String productName;
    private final Double protein; // 프로틴
    private final Double totalCarbohydrate; //탄수화물
    private final Double sugars; // 당
    private final Double totalFat; // 지방

    public static ProductMainPageDto fromEntity(Product product) {
        return new ProductMainPageDto(
                product.getId(),
                product.getName(),
                product.getProtein(),
                product.getTotalCarbohydrate(),
                product.getSugars(),
                product.getTotalFat()
        );
    }
}
