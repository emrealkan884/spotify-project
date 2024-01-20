package com.berkemre.spotifyproject.core.exceptions.handlers;

import com.berkemre.spotifyproject.core.exceptions.problemDetails.BusinessProblemDetails;
import com.berkemre.spotifyproject.core.exceptions.problemDetails.ValidationProblemDetails;
import com.berkemre.spotifyproject.core.exceptions.types.BusinessException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlers {
  // Uygulamanın neresinde olursa olsun fırlayan runtime exception'ları yakalaması için
  // ExceptionHandler ekle
  // ExceptionHandler metodu içerisinde bu metodun hangi exception türünü handle edeceğini söyle
  // Yani uygulamanın herhangi bir yerinde  MethodArgumentNotValidException fırlarsa bu metodu
  // çalıştır.
  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ValidationProblemDetails handleValidationException(
      MethodArgumentNotValidException exception) {
    Map<String, String> validationErrors = new HashMap<>();
    exception.getBindingResult().getFieldErrors().stream()
        .map(error -> validationErrors.put(error.getField(), error.getDefaultMessage()))
        .collect(Collectors.toList());

    ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
    validationProblemDetails.setErrors(validationErrors);
    return validationProblemDetails;
  }

  @ExceptionHandler({BusinessException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BusinessProblemDetails handleBusinessException(BusinessException exception) {
    BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
    businessProblemDetails.setDetail(exception.getMessage());
    return businessProblemDetails;
  }
}
