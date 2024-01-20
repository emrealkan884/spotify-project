package com.berkemre.spotifyproject.core.exceptions.problemDetails;

public class BusinessProblemDetails extends ProblemDetails {
  public BusinessProblemDetails() {
    setTitle("Business Rule Violation");
    setType("http://spotify.com/exceptions/business");
    setStatus("400");
  }
}
