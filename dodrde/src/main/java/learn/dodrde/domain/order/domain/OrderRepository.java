package learn.dodrde.domain.order.domain;

import java.util.Optional;

public interface OrderRepository {
    Order findById(OrderNo no);

    void save(Order order);
}
