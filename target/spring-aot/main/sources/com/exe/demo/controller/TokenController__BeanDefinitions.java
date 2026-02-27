package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TokenController}.
 */
@Generated
public class TokenController__BeanDefinitions {
  /**
   * Get the bean definition for 'tokenController'.
   */
  public static BeanDefinition getTokenControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TokenController.class);
    InstanceSupplier<TokenController> instanceSupplier = InstanceSupplier.using(TokenController::new);
    instanceSupplier = instanceSupplier.andThen(TokenController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
