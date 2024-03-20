package learn.dodrde.domain.order;

import lombok.Getter;

/**
 * 주문 수신자 도메인입니다.
 * 주문을 받는 사람의 이름과 전화번호를 나타냅니다.
 * 도메인이 될수 있습니다.
 */
@Getter
public class Receiver {
    private String receiverName;
    private String receiverPhoneNumber;

    public Receiver(String receiverName, String receiverPhoneNumber) {
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
    }
}
