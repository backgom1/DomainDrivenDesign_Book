package learn.dodrde.domain.order.domain;

import lombok.Getter;

/**
 * 금액 도메인입니다.
 */
@Getter
public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    /**
     * 개수 총 금액 더하기
     * @param money
     * @return
     */
    public Money calculateAmount(Money money) {
        return new Money(this.value + money.value);
    }

    /**
     * 금액을 곱합니다.
     * @param multiplier
     * @return
     */
    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }
}
