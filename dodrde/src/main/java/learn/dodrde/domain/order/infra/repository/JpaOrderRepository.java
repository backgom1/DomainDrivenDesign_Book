package learn.dodrde.domain.order.infra.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import learn.dodrde.domain.order.domain.Order;
import learn.dodrde.domain.order.domain.OrderNo;
import learn.dodrde.domain.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findById(OrderNo no) {
        return em.find(Order.class, no);
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }
}
