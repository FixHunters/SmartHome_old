package com.smarthome.flat.svc.controller;

public class BadRequestException extends RuntimeException {

  /** serial id */
  private static final long serialVersionUID = 3850313102575352962L;

  public BadRequestException(String message) {
    super(message);
  }
}
