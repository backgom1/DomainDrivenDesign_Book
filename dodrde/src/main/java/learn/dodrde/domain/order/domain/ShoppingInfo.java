package learn.dodrde.domain.order.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import lombok.Getter;

/**
 * 배송지 정보 도메인입니다.
 */
@Getter
public class ShoppingInfo {

    @Embedded
    private Receiver receiver;

    @Embedded
    private Address address;

    public ShoppingInfo(Receiver receiver, Address address) {
        this.receiver = receiver;
        this.address = address;
    }
}
