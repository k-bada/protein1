package protein.proteinspring.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import protein.proteinspring.dto.*;
import protein.proteinspring.exception.BadRequestExcpetion;
import protein.proteinspring.service.UserService;

import javax.validation.Valid;

@Tag(name = "User", description = "사용자 정보 관련 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "회원가입합니다.")
    @PostMapping("/signup")
    public ResponseDto<Long> addUser(@Valid @RequestBody UserAddRequestDto requestDto) {
        return ResponseDto.of(userService.addUser(requestDto));
    }

    @Operation(summary = "로그인", description = "로그인합니다.")
    @PostMapping("/signin")
    public ResponseDto<Long> findUser(@Valid @RequestBody UserFindRequestDto requestDto) {
        return ResponseDto.of(userService.findUser(requestDto));
    }

    @Operation(summary = "사용자 프로필", description = "사용자의 프로필을 열람합니다.")
    @GetMapping("/{userId}")
    public ResponseDto<UserDto> userProfile(@PathVariable Long userId) {
        if (userId == null) {
            throw new BadRequestExcpetion( "userId가 널이면 안됩니다.");
        }

        return ResponseDto.of(userService.userProfile(userId));
    }

    @Operation(summary = "프로필 수정", description = "사용자의 프로필을 수정합니다.")
    @PutMapping("/{userId}/edit")
    public ResponseDto<Long> userProfileEdit(@PathVariable Long userId, @Valid @RequestBody UserProfileRequestDto requestDto) {
        if (userId == null) {
            throw new BadRequestExcpetion( "userId가 널이면 안됩니다.");
        }

        return ResponseDto.of(userService.userProfileEdit(userId, requestDto));
    }

    @Operation(summary = "사용자 모드 수정", description = "사용자에게 설정된 모드를 변경합니다.")
    @PutMapping("/{userId}/mode")
    public ResponseDto<UserModeDto> userModeEdit(@PathVariable Long userId, @Valid @RequestBody UserModeRequestDto requestDto) {
        if (userId == null) {
            throw new BadRequestExcpetion( "userId가 널이면 안됩니다.");
        }

        return ResponseDto.of(userService.userModeEdit(userId, requestDto));

    }

    @Operation(summary = "목표 체중 변경", description = "현재 체중과 목표 체중을 변경합니다.")
    @PutMapping("{userId}/weight")
    public ResponseDto<Long> userWeight(@PathVariable Long userId, @Valid @RequestBody UserWeightRequestDto requestDto) {
        if (userId == null) {
            throw new BadRequestExcpetion( "userId가 널이면 안됩니다.");
        }

        return ResponseDto.of(userService.userWeightEdit(userId, requestDto));
    }
}
