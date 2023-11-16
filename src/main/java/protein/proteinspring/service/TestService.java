package protein.proteinspring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import protein.proteinspring.enums.GenderType;
import protein.proteinspring.enums.ModeType;
import protein.proteinspring.repository.MealRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import protein.proteinspring.entity.Product;
import protein.proteinspring.entity.User;
import protein.proteinspring.repository.ProductRepository;
import protein.proteinspring.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class TestService {
    private final MealRepository mealRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Void addTestItems() {
        Product product1 = new Product().setId(1L).setCalories(100.0).setProtein(10.0).setTotalCarbohydrate(100.0).setTotalFat(100.0).setName("사과");
        Product product2 = new Product().setId(2L).setCalories(200.0).setProtein(20.0).setTotalCarbohydrate(200.0).setTotalFat(200.0).setName("배");
        Product product3 = new Product().setId(3L).setCalories(300.0).setProtein(30.0).setTotalCarbohydrate(300.0).setTotalFat(300.0).setName("망고");
        productRepository.saveAll(List.of(product1, product2, product3));
        User user = new User().setId(1L).setName("김하나").setMail("12345@123").setPassword("123").setGender(GenderType.FEMALE).setBirthDate(LocalDate.of(2023, 10, 3)).setHeight(170.0).setWeight(50.0).setGoalWeight(50.0).setMode(ModeType.NORMAL);
        userRepository.save(user);
        return null;
    }

}
