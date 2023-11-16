package protein.proteinspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class ProductMainPageRequestDto {
    @NotNull
    private final Long productId;
}
