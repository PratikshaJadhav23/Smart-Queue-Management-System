package com.exe.demo;

import com.exe.demo.repository.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link SmartQueueManagementApplication}.
 */
@Generated
public class SmartQueueManagementApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'smartQueueManagementApplication'.
   */
  public static BeanDefinition getSmartQueueManagementApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SmartQueueManagementApplication.class);
    beanDefinition.setTargetType(SmartQueueManagementApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(SmartQueueManagementApplication.class);
    beanDefinition.setInstanceSupplier(SmartQueueManagementApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'testDB'.
   */
  private static BeanInstanceSupplier<CommandLineRunner> getTestDBInstanceSupplier() {
    return BeanInstanceSupplier.<CommandLineRunner>forFactoryMethod(SmartQueueManagementApplication$$SpringCGLIB$$0.class, "testDB", UserRepository.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("smartQueueManagementApplication", SmartQueueManagementApplication.class).testDB(args.get(0)));
  }

  /**
   * Get the bean definition for 'testDB'.
   */
  public static BeanDefinition getTestDBBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CommandLineRunner.class);
    beanDefinition.setFactoryBeanName("smartQueueManagementApplication");
    beanDefinition.setInstanceSupplier(getTestDBInstanceSupplier());
    return beanDefinition;
  }
}
