package com.exe.demo.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CounterController}.
 */
@Generated
public class CounterController__BeanDefinitions {
  /**
   * Get the bean definition for 'counterController'.
   */
  public static BeanDefinition getCounterControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CounterController.class);
    InstanceSupplier<CounterController> instanceSupplier = InstanceSupplier.using(CounterController::new);
    instanceSupplier = instanceSupplier.andThen(CounterController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
