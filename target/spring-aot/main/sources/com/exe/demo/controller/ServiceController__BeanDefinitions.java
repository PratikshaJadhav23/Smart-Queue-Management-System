package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ServiceController}.
 */
@Generated
public class ServiceController__BeanDefinitions {
  /**
   * Get the bean definition for 'serviceController'.
   */
  public static BeanDefinition getServiceControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceController.class);
    InstanceSupplier<ServiceController> instanceSupplier = InstanceSupplier.using(ServiceController::new);
    instanceSupplier = instanceSupplier.andThen(ServiceController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
