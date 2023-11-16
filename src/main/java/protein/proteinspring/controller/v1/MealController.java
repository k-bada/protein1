package protein.proteinspring.controller.v1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import protein.proteinspring.dto.*;
import protein.proteinspring.entity.Meal;
import protein.proteinspring.enums.MealType;
import protein.proteinspring.exception.BadRequestExcpetion;
import protein.proteinspring.service.MealService;
import protein.proteinspring.service.TestService;

@Tag(name = "Meal + tip", description = "식사 기록 관련 API + 팁")
@RequiredArgsConstructor
@RequestMapping("/api/v1/meal")
@RestController
public class MealController {
    private final MealService mealService;
    private final TestService testService;

    // TODO: 테스트용 API 삭제
    @Hidden
    @GetMapping("/test")
    public ResponseDto<Void> test() {
        return ResponseDto.of(testService.addTestItems());
    }

    @Operation(summary = "식사 기록 추가", description = "새로운 식사 기록을 추가합니다.")
    @PostMapping("/log")
    public ResponseDto<MealLogDto> addMealLog(@Valid @RequestBody MealLogRequestDto requestDto) {
        return ResponseDto.of(mealService.addMealLog(requestDto));
    }

    @Operation(summary = "특정일의 식사 기록 제공", description = "지정한 일자의 식사 기록을 제공합니다.")
    @GetMapping("/log/{userId}/{mealDateString}")
    public ResponseDto<Map<MealType, List<MealLogDto>>> findMealLog(@PathVariable Long userId, @PathVariable String mealDateString) {
        if (userId == null) {
            throw new BadRequestExcpetion( "userId가 널이면 안됩니다.");
        }
        try {
            LocalDate mealDate = LocalDate.parse(mealDateString);
            return ResponseDto.of(mealService.findMealLog(userId, mealDate));
        } catch (DateTimeParseException e) {
            throw new BadRequestExcpetion("잘못된 날짜 스트링입니다. YYYY-MM-dd로 지정해주세요.");
        }
    }

    @Operation(summary = "금일 식사 기록 통계 제공", description = "오늘 일자의 식사 기록 통계를 제공합니다.")
    @GetMapping("/log/summary/today/{userId}")
    public ResponseDto<MealSummaryDto> summaryMeals(@PathVariable Long userId) {
        if (userId == null) {
            throw new BadRequestExcpetion( "userId가 널이면 안됩니다.");
        }

        return ResponseDto.of(mealService.summaryTodayMeals(userId));
    }

    @Operation(summary = "세 끼 다 먹은 날짜", description = "해당 월에 세 끼 다 먹은 날짜를 제공합니다.")
    @GetMapping("/log/summary/{userId}/month/{month}")
    public ResponseDto<MealMonthSummaryDto> summaryMonthMeals(@PathVariable Long userId, @PathVariable int month) {
        if (userId == null) {
            throw new BadRequestExcpetion( "userId가 널이면 안됩니다.");
        } else if (month < 1 || 12 < month) {
            throw new BadRequestExcpetion( "month가 1보다 작거나 12보다 크면 안됩니다.");
        }
        return ResponseDto.of(mealService.summaryMonthMeals(userId, month));
    }

    @Operation(summary = "식단 팁 제공", description = "랜덤으로 식단 구성 팁을 제공합니다.")
    @GetMapping("/tip")
    public ResponseDto<String> getTip() {
        return ResponseDto.of(mealService.getTip());
    }
}
