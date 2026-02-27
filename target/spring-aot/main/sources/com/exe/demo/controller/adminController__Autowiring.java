package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link adminController}.
 */
@Generated
public class adminController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static adminController apply(RegisteredBean registeredBean, adminController instance) {
    AutowiredFieldValueResolver.forRequiredField("counterRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("tokenRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("serviceRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
