package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CartRepository {
    private static final CartRepository INSTANCE = new CartRepository();

    private final ObservableList<CartItem> cartItems = FXCollections.observableArrayList();
    private String paymentMethod = "";
    private String deliveryMethod = "";

    private CartRepository() {}

    public static CartRepository getInstance() { return INSTANCE; }

    public ObservableList<CartItem> getCartItems() { return cartItems; }

    public void setCartItems(List<CartItem> items) {
        cartItems.clear();
        if (items != null) cartItems.addAll(items);
    }

    public void setPaymentMethod(String m) { this.paymentMethod = m; }
    public String getPaymentMethod() { return paymentMethod; }

    public void setDeliveryMethod(String m) { this.deliveryMethod = m; }
    public String getDeliveryMethod() { return deliveryMethod; }
}

