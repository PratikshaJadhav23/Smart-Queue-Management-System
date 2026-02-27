package com.exe.demo.repository;

import com.exe.demo.model.ServiceEntity;
import com.exe.demo.model.Token;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link TokenRepository}.
 */
@Generated
public class TokenRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public TokenRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link TokenRepository#countByStatus(java.lang.String)}.
   */
  public long countByStatus(String status) {
    String queryString = "SELECT COUNT(t) FROM Token t WHERE t.status = :status";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("status", status);

    return (Long) convertOne(query.getSingleResultOrNull(), false, Long.class);
  }

  /**
   * AOT generated implementation of {@link TokenRepository#countByStatusAndServiceIdAndIdLessThan(java.lang.String,java.lang.Long,java.lang.Long)}.
   */
  public long countByStatusAndServiceIdAndIdLessThan(String status, Long serviceId, Long id) {
    String queryString = "SELECT COUNT(t) FROM Token t WHERE t.status = :status AND t.service.id = :serviceId AND t.id < :id";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("status", status);
    query.setParameter("serviceId", serviceId);
    query.setParameter("id", id);

    return (Long) convertOne(query.getSingleResultOrNull(), false, Long.class);
  }

  /**
   * AOT generated implementation of {@link TokenRepository#findByServiceAndStatus(com.exe.demo.model.ServiceEntity,java.lang.String)}.
   */
  public List<Token> findByServiceAndStatus(ServiceEntity service, String status) {
    String queryString = "SELECT t FROM Token t WHERE t.service = :service AND t.status = :status";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("service", service);
    query.setParameter("status", status);

    return (List<Token>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link TokenRepository#findByTokenNumber(java.lang.String)}.
   */
  public Token findByTokenNumber(String tokenNumber) {
    String queryString = "SELECT t FROM Token t WHERE t.tokenNumber = :tokenNumber";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("tokenNumber", tokenNumber);

    return (Token) convertOne(query.getSingleResultOrNull(), false, Token.class);
  }

  /**
   * AOT generated implementation of {@link TokenRepository#findFirstByServiceAndStatusAndPriorityTypeOrderByCreatedTimeAsc(com.exe.demo.model.ServiceEntity,java.lang.String,java.lang.String)}.
   */
  public Optional<Token> findFirstByServiceAndStatusAndPriorityTypeOrderByCreatedTimeAsc(
      ServiceEntity service, String status, String priorityType) {
    String queryString = "SELECT t FROM Token t WHERE t.service = :service AND t.status = :status AND t.priorityType = :priorityType ORDER BY t.createdTime asc";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("service", service);
    query.setParameter("status", status);
    query.setParameter("priorityType", priorityType);
    if (query.getMaxResults() != Integer.MAX_VALUE) {
      if (query.getMaxResults() > 1 && query.getFirstResult() > 0) {
        query.setFirstResult(query.getFirstResult() - (query.getMaxResults() - 1));
      }
    }
    query.setMaxResults(1);

    return Optional.ofNullable((Token) convertOne(query.getSingleResultOrNull(), false, Token.class));
  }

  /**
   * AOT generated implementation of {@link TokenRepository#findTop3ByStatusOrderByIdAsc(java.lang.String)}.
   */
  public List<Token> findTop3ByStatusOrderByIdAsc(String status) {
    String queryString = "SELECT t FROM Token t WHERE t.status = :status ORDER BY t.id asc";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("status", status);
    if (query.getMaxResults() != Integer.MAX_VALUE) {
      if (query.getMaxResults() > 3 && query.getFirstResult() > 0) {
        query.setFirstResult(query.getFirstResult() - (query.getMaxResults() - 3));
      }
    }
    query.setMaxResults(3);

    return (List<Token>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link TokenRepository#findTopByStatusOrderByIdDesc(java.lang.String)}.
   */
  public Token findTopByStatusOrderByIdDesc(String status) {
    String queryString = "SELECT t FROM Token t WHERE t.status = :status ORDER BY t.id desc";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("status", status);
    if (query.getMaxResults() != Integer.MAX_VALUE) {
      if (query.getMaxResults() > 1 && query.getFirstResult() > 0) {
        query.setFirstResult(query.getFirstResult() - (query.getMaxResults() - 1));
      }
    }
    query.setMaxResults(1);

    return (Token) convertOne(query.getSingleResultOrNull(), false, Token.class);
  }
}
