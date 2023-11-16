package protein.proteinspring.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import protein.proteinspring.enums.GenderType;
import protein.proteinspring.enums.ModeType;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "`user`", uniqueConstraints = { @UniqueConstraint( columnNames = {"mail"}) })
public class User {
    //DB가 자동으로 기본 키 값 생성하고 할당.JPA는 DB에서 생성된 값 엔티티 필드에 저장
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Column(name = "`password`")
    private String password;
    @NotNull
    @Column(unique = true)
    private String mail;
    @NotNull
    private GenderType gender;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Double height;
    @NotNull
    private Double weight;
    @NotNull
    private Double goalWeight;
    @NotNull
    private ModeType mode;
}
//랜덤 음식 추천은 api에서 하는 걸로
