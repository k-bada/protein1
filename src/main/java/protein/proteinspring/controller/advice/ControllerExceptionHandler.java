package protein.proteinspring.controller.advice;

import protein.proteinspring.dto.ResponseDto;
import protein.proteinspring.exception.BadRequestExcpetion;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = { BadRequestExcpetion.class, MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<Void> badRequestHandler(Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        return ResponseDto.fail(ex.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto<Void> generalExceptionHandler(Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        return ResponseDto.fail(ex.getMessage());
    }
}
