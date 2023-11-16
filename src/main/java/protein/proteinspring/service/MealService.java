package protein.proteinspring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import protein.proteinspring.dto.MealMonthSummaryDto;
import protein.proteinspring.enums.MealType;
import protein.proteinspring.exception.BadRequestExcpetion;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import protein.proteinspring.dto.MealLogDto;
import protein.proteinspring.dto.MealLogRequestDto;
import protein.proteinspring.dto.MealSummaryDto;
import protein.proteinspring.entity.Meal;
import protein.proteinspring.entity.Product;
import protein.proteinspring.entity.User;
import protein.proteinspring.repository.MealRepository;
import protein.proteinspring.repository.ProductRepository;
import protein.proteinspring.repository.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class MealService {
    private final MealRepository mealRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private static final List<String> tips = List.of(
            "하루 물 섭취량은 1.5 ~ 2L 입니다.",
            "식사를 하실 때, 채소 먼저 드세요",
            "아침식사는 거르지 마세요.",
            "탄산음료는 권장하지 않습니다.",
            "채소와 과일에는 많은 식이섬유가 포함되어있습니다."
    );

    private static final Random randomGenerator = new Random();

    public MealLogDto addMealLog(MealLogRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.getProductId())
                                           .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 상품입니다."));
        User user = userRepository.findById(requestDto.getUserId())
                                  .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        Meal meal = mealRepository.save(
                new Meal().setUser(user)
                          .setProduct(product)
                          .setType(requestDto.getMealType())
                          .setMealDateTime(requestDto.getMealDateTime())
        );

        return MealLogDto.fromEntity(meal);
    }

    public Map<MealType, List<MealLogDto>> findMealLog(Long userId, LocalDate mealDate) {
        userRepository.findById(userId)
                      .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        List<Meal> mealLogs = mealRepository.findAllByUserId(userId);
        return mealLogs.stream()
                       .map(MealLogDto::fromEntity)
                       .filter(mealLogDto -> mealDate.equals(mealLogDto.getMealTime().toLocalDate()))
                       .collect(Collectors.groupingBy(MealLogDto::getType));
    }

    public MealSummaryDto summaryTodayMeals(Long userId) {
        userRepository.findById(userId)
                      .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        LocalDate today = LocalDate.now();
        List<Meal> mealLogs = mealRepository.findAllByUserId(userId);
        List<Meal> todayMeals = mealLogs.stream()
                                     .filter(meal -> today.equals(meal.getMealDateTime().toLocalDate()))
                                     .collect(Collectors.toList());
        return MealSummaryDto.fromTodayMeals(todayMeals);
    }

    public MealMonthSummaryDto summaryMonthMeals(Long userId, int month) {
        userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        List<Meal> mealLogs = mealRepository.findAllByUserId(userId);
        Map<LocalDate, List<Meal>> mealByDate = mealLogs.stream()
                .filter(meal -> meal.getMealDateTime().getMonth().getValue() == month)
                .collect(Collectors.groupingBy(meal -> meal.getMealDateTime().toLocalDate()));
        List<LocalDate> fullMealDate = mealByDate.entrySet().stream()
                .filter(e ->
                        e.getValue().stream().anyMatch(meal -> meal.getType() == MealType.BREAKFAST) &&
                        e.getValue().stream().anyMatch(meal -> meal.getType() == MealType.LUNCH) &&
                        e.getValue().stream().anyMatch(meal -> meal.getType() == MealType.DINNER))
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        return new MealMonthSummaryDto(fullMealDate);
    }

    public String getTip() {
        int idx = randomGenerator.nextInt(tips.size());
        return tips.get(idx);
    }


}
