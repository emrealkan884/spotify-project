package com.berkemre.spotifyproject.core.exceptions.types;

public class BusinessException extends RuntimeException {
  public BusinessException(String message) {
    super(message);
  }
}
