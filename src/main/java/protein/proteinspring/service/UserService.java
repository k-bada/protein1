package protein.proteinspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import protein.proteinspring.dto.*;
import protein.proteinspring.entity.User;
import protein.proteinspring.exception.BadRequestExcpetion;
import protein.proteinspring.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Long addUser(UserAddRequestDto requestDto) {
        return userRepository.save(
                new User().setName(requestDto.getName())
                        .setMail(requestDto.getMail())
                        .setPassword(requestDto.getPassword())
                        .setGender(requestDto.getGenderType())
                        .setBirthDate(requestDto.getBirthDate())
                        .setHeight(requestDto.getHeight())
                        .setWeight(requestDto.getWeight())
                        .setGoalWeight(requestDto.getGoalWeight())
                        .setMode(requestDto.getModeType())
        ).getId();
    }

    public Long findUser(UserFindRequestDto requestDto) {
        User user = userRepository.findByMailAndPassword(requestDto.getMail(), requestDto.getPassword())
                .orElseThrow(() -> new BadRequestExcpetion("사용자를 찾을 수 없습니다. 메일 or 패스워드를 확인하세요!"));
    return user.getId();
    }

    public UserDto userProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        return UserDto.fromEntity(user);
    }

    public Long userProfileEdit(Long userId, UserProfileRequestDto requestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        if(requestDto.getName() != null) {
            user.setName(requestDto.getName());
        }
        if(requestDto.getPassword() != null) {
            user.setPassword(requestDto.getPassword());
        }
        if(requestDto.getGenderType() != null) {
            user.setGender(requestDto.getGenderType());
        }
        if(requestDto.getBirthDate() != null) {
            user.setBirthDate(requestDto.getBirthDate());
        }
        if(requestDto.getHeight() != null) {
            user.setHeight(requestDto.getHeight());
        }
        if(requestDto.getWeight() != null) {
            user.setWeight(requestDto.getWeight());
        }

        return userRepository.save(user).getId();
    }

    public UserModeDto userModeEdit(Long userId, UserModeRequestDto requestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        if(requestDto.getMode() != null) {
            user.setMode(requestDto.getMode());
        }
        userRepository.save(user);
        return UserModeDto.fromEntity(user);

    }

    public Long userWeightEdit(Long userId, UserWeightRequestDto requestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));
        if(requestDto.getWeight() != null) {
            user.setWeight(requestDto.getWeight());
        }
        if(requestDto.getGoalWeight() != null) {
            user.setGoalWeight(requestDto.getGoalWeight());
        }

        return userRepository.save(user).getId();
    }
}
