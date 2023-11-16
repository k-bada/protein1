package protein.proteinspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.enums.GenderType;

import java.time.LocalDate;


@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UserProfileRequestDto {
    private final String name;
    private final String password;
    private final GenderType genderType;
    private final LocalDate birthDate;
    private final Double height;
    private final Double weight;
}
