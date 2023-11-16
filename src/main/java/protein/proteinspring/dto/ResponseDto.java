package protein.proteinspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseDto<T> {
    public static <T> ResponseDto<T> of(T result) {
        return new ResponseDto<>(true, result, null);
    }

    public static <T> ResponseDto<T> fail(String errorMsg) {
        return new ResponseDto<>(false, null, errorMsg);
    }
    private final boolean success;
    private final T result;
    private final String errorMsg;
}
