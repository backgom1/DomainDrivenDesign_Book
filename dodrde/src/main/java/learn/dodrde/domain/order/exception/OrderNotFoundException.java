package learn.dodrde.domain.order.exception;

public class OrderNotFoundException extends RuntimeException {

    private static final String MESSAGE = "주문 정보를 찾을 수 없습니다.";

    public OrderNotFoundException() {
        super(MESSAGE);
    }
}
