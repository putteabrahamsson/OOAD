package shop;

import shop.undoRedo.HistoryStack;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Create new items
        Product item1 = new Product("Coca-Cola");
        Product item2 = new Product("Hushållsost");
        Product item3 = new Product("Kaffe");
        Product item4 = new Product("Handskar");
        Product item5 = new Product("Mjölk");
        Product item6 = new Product("Hundmat");

        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(item1, 21.50, 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(item2, 14.50, 1);
        ShoppingCartItem shoppingCartItem3 = new ShoppingCartItem(item3, 29.00, 1);
        ShoppingCartItem shoppingCartItem4 = new ShoppingCartItem(item4, 99.00, 1);
        ShoppingCartItem shoppingCartItem5 = new ShoppingCartItem(item5, 28.50, 1);
        ShoppingCartItem shoppingCartItem6 = new ShoppingCartItem(item6, 39.99, 1);

        cart.addCartItem(shoppingCartItem1);
        cart.addCartItem(shoppingCartItem2);
        cart.addCartItem(shoppingCartItem3);
        cart.addCartItem(shoppingCartItem4);
        cart.addCartItem(shoppingCartItem5);
        cart.addCartItem(shoppingCartItem6);

        // Reference to HistoryStack
        HistoryStack stack = new HistoryStack();

        // Undo & Redo
        cart.undo(stack);
        cart.redo(stack);
        cart.undo(stack);
        cart.undo(stack);

        // Change quantity
        shoppingCartItem1.setQuantity(5);

        // Undo & Redo
        cart.undo(stack);
        cart.redo(stack);

        // Print receipt
        System.out.println(cart.receipt());

    }
}
