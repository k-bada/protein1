package protein.proteinspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.enums.GenderType;
import protein.proteinspring.enums.ModeType;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UserAddRequestDto {
    @NotNull
    private final String name;
    @NotNull
    private final String mail;
    @NotNull
    private final String password;
    @NotNull
    private final GenderType genderType;
    @NotNull
    private final LocalDate birthDate;
    @NotNull
    private final Double height;
    @NotNull
    private final Double weight;
    @NotNull
    private final Double goalWeight;
    @NotNull
    private final ModeType modeType;
}

