package shop.discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ThreeForTwo implements DiscountInterface {
    String discount;

    @Override
    public BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            if(item.quantity() > 2 && item.quantity() < 4) {
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum).subtract(item.itemCost());
                discount = item.itemCost().toString();
            } else {
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
            }
        }

        return sum;
    }

    @Override
    public String amountOfDiscount() {
        return "-"+ discount;
    }

    @Override
    public String name() {
        return "3 for 2";
    }

}
