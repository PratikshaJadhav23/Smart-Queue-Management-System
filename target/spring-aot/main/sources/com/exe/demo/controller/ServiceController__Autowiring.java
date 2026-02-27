package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ServiceController}.
 */
@Generated
public class ServiceController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ServiceController apply(RegisteredBean registeredBean, ServiceController instance) {
    AutowiredFieldValueResolver.forRequiredField("serviceRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
