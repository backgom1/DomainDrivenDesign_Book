package learn.dodrde.domain.order;

import lombok.Getter;

/**
 * 배송지 정보 도메인입니다.
 */
@Getter
public class ShoppingInfo {
    private Receiver receiver;
    private Address address;

    public ShoppingInfo(Receiver receiver, Address address) {
        this.receiver = receiver;
        this.address = address;
    }
}
