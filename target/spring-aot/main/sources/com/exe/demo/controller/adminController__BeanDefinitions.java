package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link adminController}.
 */
@Generated
public class adminController__BeanDefinitions {
  /**
   * Get the bean definition for 'adminController'.
   */
  public static BeanDefinition getAdminControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(adminController.class);
    InstanceSupplier<adminController> instanceSupplier = InstanceSupplier.using(adminController::new);
    instanceSupplier = instanceSupplier.andThen(adminController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
