package protein.proteinspring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //DB가 아이디 값 자동으로 만들어주는 것. = entity
    private Long id;
    private String name;
    private String brandName;
    private Double calories; // 칼로리
    private Double protein; // 프로틴
    private Double totalCarbohydrate; //탄수화물
    private Double sugars; // 당
    private Double totalFat; // 지방
    private Double saturatedFat; // 포화지방
    private Double transFat; // 트랜스지방
    private Double sodium; // 나트륨
    private Double cholesterol; // 콜레스테롤
}
