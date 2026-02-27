package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PublicController}.
 */
@Generated
public class PublicController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PublicController apply(RegisteredBean registeredBean, PublicController instance) {
    AutowiredFieldValueResolver.forRequiredField("tokenRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
