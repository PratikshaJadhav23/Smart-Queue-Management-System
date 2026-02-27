package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CounterController}.
 */
@Generated
public class CounterController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CounterController apply(RegisteredBean registeredBean, CounterController instance) {
    AutowiredFieldValueResolver.forRequiredField("counterRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("serviceRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
