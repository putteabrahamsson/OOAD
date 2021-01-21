package shop.discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NoDiscount implements DiscountInterface {
    @Override
    public BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }

        return sum;
    }

    @Override
    public String amountOfDiscount() {
        return "";
    }

    @Override
    public String name() {
        return "";
    }
}
