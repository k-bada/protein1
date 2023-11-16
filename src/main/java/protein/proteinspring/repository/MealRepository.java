package protein.proteinspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import protein.proteinspring.entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    @Query("SELECT m FROM Meal AS m WHERE m.user.id = :userId")
    List<Meal> findAllByUserId(@Param("userId") Long userId);
}
