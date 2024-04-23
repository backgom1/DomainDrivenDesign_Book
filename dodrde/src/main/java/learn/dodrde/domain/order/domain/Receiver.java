package learn.dodrde.domain.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 주문 수신자 도메인입니다.
 * 주문을 받는 사람의 이름과 전화번호를 나타냅니다.
 * 도메인이 될수 있습니다.
 */
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Receiver {

    @Column(name = "reciver_name")
    private String name;

    @Column(name="reciver_phone")
    private String phone;

    public Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
