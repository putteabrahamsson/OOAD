package shop;

import java.math.BigDecimal;

public class ReceiptObject {
    BigDecimal sum = BigDecimal.ZERO;
    String name;
    String discount;

    public ReceiptObject(BigDecimal sum, String name, String discount){
        this.sum = sum;
        this.name = name;
        this.discount = discount;
    }
}
