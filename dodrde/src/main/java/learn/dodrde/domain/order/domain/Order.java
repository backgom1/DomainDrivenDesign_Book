package learn.dodrde.domain.order.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 주문 도메인입니다.
 * 도메인에 기능을 작성할 수 있습니다.
 */

@Entity
@Table(name="purchase_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @EmbeddedId
    private OrderNo id;

    private Orderer orderer;

    @Embedded
    private List<OrderLine> orderLines;
    @Embedded
    private Money totalAmounts;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private OrderState state;

    @Embedded
    private ShoppingInfo shoppingInfo;

    public Order(List<OrderLine> orderLines, ShoppingInfo shoppingInfo) {
        setOrderLines(orderLines);
        setShoppingInfo(shoppingInfo);
    }

    private void setShoppingInfo(ShoppingInfo shoppingInfo) {
        if (shoppingInfo == null) {
            throw new IllegalArgumentException("배송지 정보는 필수입니다.");
        }
        this.shoppingInfo = shoppingInfo;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrderLine(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    /**
     * 주문 라인이 하나 이상인지 확인합니다.
     *
     * @param orderLines
     */
    private void verifyAtLeastOneOrderLine(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("주문 라인은 하나 이상이어야 합니다.");
        }
    }

    /**
     * 주문의 총 금액을 계산합니다.
     */
    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(OrderLine::getAmount)
                .sum();
        this.totalAmounts = new Money(sum);
    }

    public void changeShoppingInfo(ShoppingInfo shoppingInfo) {
        verifyNotYetShipped();
        setShoppingInfo(shoppingInfo);
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("배송이 시작된 주문은 배송지 정보를 변경할 수 없습니다.");
        }
    }

    /**
     * 주문 상태를 변경합니다.
     *
     * @param state 변경할 주문 상태
     */
    public void changeShopped() {
    }


    /**
     * 주문 상태를 변경합니다.
     *
     * @param state 변경할 주문 상태
     */
    public void changeShoppingInfo() {
    }

    /**
     * 주문을 취소합니다.
     */
    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    /**
     * 주문을 완료합니다.
     */
    public void completePayment() {
    }
}
