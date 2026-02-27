package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PublicController}.
 */
@Generated
public class PublicController__BeanDefinitions {
  /**
   * Get the bean definition for 'publicController'.
   */
  public static BeanDefinition getPublicControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PublicController.class);
    InstanceSupplier<PublicController> instanceSupplier = InstanceSupplier.using(PublicController::new);
    instanceSupplier = instanceSupplier.andThen(PublicController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
