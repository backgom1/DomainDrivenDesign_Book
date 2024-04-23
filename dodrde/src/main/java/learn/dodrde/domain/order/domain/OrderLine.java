package learn.dodrde.domain.order.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 주문 라인 도메인입니다.
 * 도메인에 기능을 작성할 수 있습니다.
 * 주문 라인은 주문에 포함된 상품의 수량과 가격을 나타냅니다.
 * 상품(product)을 얼마(price)에 몇개 살지(quantity) 담고있고 그에 따른 가격을 계산합니다.
 */
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLine {

    private Product product;
    private Money price;
    private int quantity;
    private int amount;

    public OrderLine(Product product, Money price, int quantity, int amount) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    private Money calculateAmount() {
        return price.multiply(quantity);
    }

    public int getAmount() {
        return calculateAmount().getValue();
    }

}
