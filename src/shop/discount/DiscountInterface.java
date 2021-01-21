package shop.discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface DiscountInterface {
    BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items);
    String amountOfDiscount();
    String name();
}
