package com.berkemre.spotifyproject.core.exceptions.problemDetails;

import java.util.Map;
import lombok.Data;

@Data
public class ValidationProblemDetails extends ProblemDetails {
  private Map<String, String> errors;

  public ValidationProblemDetails() {
    setTitle("Validation Rule Violation");
    setDetail("Validation Problem");
    setType("http://spotify.com/exceptions/validation");
    setStatus("400");
  }

}
