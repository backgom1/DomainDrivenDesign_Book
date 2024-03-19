package learn.dodrde.domain.order;

public class Order {

    private OrderState state;
    private ShoppingInfo shoppingInfo;

    public void changeShoppingInfo(ShoppingInfo shoppingInfo){
        if(!state.isShippingChangeable()){
            throw new IllegalStateException("can't change shipping in " + state);
        }
        this.shoppingInfo = shoppingInfo;
    }
}
