package com.exe.demo.repository;

import com.exe.demo.model.Counter;
import com.exe.demo.model.ServiceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link CounterRepository}.
 */
@Generated
public class CounterRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public CounterRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link CounterRepository#findFirstByServiceAndStatus(com.exe.demo.model.ServiceEntity,java.lang.String)}.
   */
  public Optional<Counter> findFirstByServiceAndStatus(ServiceEntity service, String status) {
    String queryString = "SELECT c FROM Counter c WHERE c.service = :service AND c.status = :status";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("service", service);
    query.setParameter("status", status);
    if (query.getMaxResults() != Integer.MAX_VALUE) {
      if (query.getMaxResults() > 1 && query.getFirstResult() > 0) {
        query.setFirstResult(query.getFirstResult() - (query.getMaxResults() - 1));
      }
    }
    query.setMaxResults(1);

    return Optional.ofNullable((Counter) convertOne(query.getSingleResultOrNull(), false, Counter.class));
  }
}
