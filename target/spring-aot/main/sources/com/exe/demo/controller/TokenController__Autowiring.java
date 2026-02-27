package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TokenController}.
 */
@Generated
public class TokenController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TokenController apply(RegisteredBean registeredBean, TokenController instance) {
    AutowiredFieldValueResolver.forRequiredField("serviceRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("tokenRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
