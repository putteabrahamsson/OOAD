package shop.discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Discount {
    private DiscountInterface discountInterface;

    public ArrayList<ShoppingCartItem> items = new ArrayList<>();

    //public Discount(DiscountInterface discountInterface) {
       // this.discountInterface = discountInterface;
    //}

    public Discount(ArrayList<ShoppingCartItem> shoppingCart) {
        this.items = shoppingCart;
    }

    public BigDecimal checkDiscount(DiscountInterface discountInterface) {
        this.discountInterface = discountInterface;
        BigDecimal sum = this.discountInterface.returnDiscount(items);

        return sum;
    }

    public DiscountInterface bestDiscount() {
        DiscountInterface currentDiscount = new NoDiscount();

        ArrayList<DiscountInterface> arr = new ArrayList<DiscountInterface>();
        arr.add(new ThreeForTwo());
        arr.add(new CheapestForFree());
        arr.add(new TenPercent());
        arr.add(new NoDiscount());

        for(DiscountInterface discount: arr) {
            double checkedDiscount = discount.returnDiscount(items).doubleValue();

            if(currentDiscount.returnDiscount(items).doubleValue() > checkedDiscount) {
                currentDiscount = discount;
            }
        }

        return currentDiscount;
    }

    public String getName() {
        return discountInterface.name();
    }

    public String getDiscount() {
        return discountInterface.amountOfDiscount();
    }
}
