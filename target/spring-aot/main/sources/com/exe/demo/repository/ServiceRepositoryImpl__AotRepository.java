package com.exe.demo.repository;

import com.exe.demo.model.ServiceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link ServiceRepository}.
 */
@Generated
public class ServiceRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public ServiceRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link ServiceRepository#findByStatusTrue()}.
   */
  public List<ServiceEntity> findByStatusTrue() {
    String queryString = "SELECT s FROM ServiceEntity s WHERE s.status = TRUE";
    Query query = this.entityManager.createQuery(queryString);

    return (List<ServiceEntity>) query.getResultList();
  }
}
