package protein.proteinspring.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import protein.proteinspring.dto.*;
import protein.proteinspring.service.ProductService;

import javax.validation.Valid;

@Tag(name = "Product", description = "음식 검색 관련 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
    private  final ProductService productService;

    @Operation(summary = "음식 검색", description = "음식 이름으로 음식을 검색합니다.")
    @PostMapping("/search")
    public ResponseDto<ProductDto> findProduct(@Valid @RequestBody ProductRequestDto requestDto) {
        return ResponseDto.of(productService.findProduct(requestDto));
    }

    @Operation(summary = "메인페이지 음식 성분", description = "메인페이지에 올라갈 '방금 검색한 음식'의 성분 일부입니다")
    @PostMapping("/search/value")
    public ResponseDto<ProductMainPageDto> productMainPageValue(@Valid @RequestBody ProductMainPageRequestDto requestDto) {
        return ResponseDto.of(productService.productMainPageValue(requestDto));
    }
}
