package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DisplayController}.
 */
@Generated
public class DisplayController__BeanDefinitions {
  /**
   * Get the bean definition for 'displayController'.
   */
  public static BeanDefinition getDisplayControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DisplayController.class);
    InstanceSupplier<DisplayController> instanceSupplier = InstanceSupplier.using(DisplayController::new);
    instanceSupplier = instanceSupplier.andThen(DisplayController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
