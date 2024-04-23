package learn.dodrde.domain.order.application.service;

import learn.dodrde.domain.order.domain.Order;
import learn.dodrde.domain.order.domain.OrderNo;
import learn.dodrde.domain.order.domain.OrderRepository;
import learn.dodrde.domain.order.domain.ShoppingInfo;
import learn.dodrde.domain.order.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangeOrderService {

    private final OrderRepository orderRepository;


    @Transactional
    public void changeShippingInfo(OrderNo no, ShoppingInfo newShoppingInfo){
        Optional<Order> orderOpt = Optional.ofNullable(orderRepository.findById(no));
        Order order = orderOpt.orElseThrow(OrderNotFoundException::new);
        order.changeShoppingInfo(newShoppingInfo);
    }
}
