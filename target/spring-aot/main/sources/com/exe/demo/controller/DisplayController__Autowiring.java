package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DisplayController}.
 */
@Generated
public class DisplayController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DisplayController apply(RegisteredBean registeredBean, DisplayController instance) {
    AutowiredFieldValueResolver.forRequiredField("tokenRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
