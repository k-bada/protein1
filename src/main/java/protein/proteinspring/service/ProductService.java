package protein.proteinspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import protein.proteinspring.dto.ProductDto;
import protein.proteinspring.dto.ProductMainPageDto;
import protein.proteinspring.dto.ProductMainPageRequestDto;
import protein.proteinspring.dto.ProductRequestDto;
import protein.proteinspring.entity.Product;
import protein.proteinspring.exception.BadRequestExcpetion;
import protein.proteinspring.repository.ProductRepository;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDto findProduct(ProductRequestDto requestDto) {
        Product product = productRepository.findByName(requestDto.getProductName())
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 음식입니다."));

        return ProductDto.fromEntity(product);
    }

    public ProductMainPageDto productMainPageValue(ProductMainPageRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.getProductId())
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 음식입니다."));

        return ProductMainPageDto.fromEntity(product);
    }
}
