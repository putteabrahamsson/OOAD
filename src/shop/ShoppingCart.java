package shop;

import shop.discount.*;
import shop.undoRedo.HistoryStack;
import shop.undoRedo.HistoryState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ShoppingCart {

    public ArrayList<ShoppingCartItem> items = new ArrayList<>();

    public void addCartItem(ShoppingCartItem item){
        items.add(item);
        addToStack(item);
    }

    public void addToStack(ShoppingCartItem item) {
        HistoryStack.addState(new HistoryState(() -> {
            items.remove(item);
        }, () -> {
            items.add(item);
        }));
    }

    public ReceiptObject calculatePrice(){
        Discount discount = new Discount(items);
        DiscountInterface bestDiscount = discount.bestDiscount();
        BigDecimal addedDiscount = discount.checkDiscount(bestDiscount);

        ReceiptObject receiptObject = new ReceiptObject(addedDiscount, discount.getName(), discount.getDiscount());
        return receiptObject;
    }

    public void undo(HistoryStack stack){
        stack.undoChanges();
    }

    public void redo(HistoryStack stack){
        stack.redoChanges();
    }

    public String receipt() {
        String line = "--------------------------------\n";
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        var list = items.stream()
                .sorted(Comparator.comparing(item -> item.product().name()))
                .collect(Collectors.toList());
        for (var each : list) {
            sb.append(String.format("%-4s %-18s % 8.2f\n",  each.quantity() + "x", each.product().name(), each.itemCost()));
        }
        sb.append(line);

        if(calculatePrice().name != "") {
            sb.append(String.format("%-24s %7s \n", calculatePrice().name, calculatePrice().discount));
        }

        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice().sum));
        return sb.toString();
    }
}
