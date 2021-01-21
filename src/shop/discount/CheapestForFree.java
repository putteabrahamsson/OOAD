package shop.discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CheapestForFree implements DiscountInterface {

    String discount;
    double lowest = 0;

    @Override
    public BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;
        for(var item: items) {
            if(items.size() > 3 && lowest == 0 || item.itemCost().doubleValue() < lowest) {
                lowest = item.itemCost().doubleValue();
                discount = item.product().name();
            }
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        return sum.subtract((new BigDecimal(lowest)));
    }

    @Override
    public String amountOfDiscount() {
        String str = String.valueOf(lowest);
        return str;
    }

    @Override
    public String name() {
        return "- 1x " + discount;
    }
}
