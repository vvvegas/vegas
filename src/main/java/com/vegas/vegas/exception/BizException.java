package com.vegas.vegas.exception;

import com.vegas.vegas.model.Error;

public class BizException extends RuntimeException {

  private Error error;

  public BizException(Error ERROR) {
    this.error = error;
  }

  public Error getError() {
    return error;
  }
}
