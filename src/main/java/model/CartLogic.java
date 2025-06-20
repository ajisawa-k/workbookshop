package model;

import java.util.ArrayList;
import java.util.List;

public class CartLogic {
    
    /**
     * Add item to cart or update quantity if item already exists
     */
    public List<Cart> add2Cart(Cart newCart, List<Cart> cartList) {
        if (cartList == null) {
            cartList = new ArrayList<>();
        }
        
        // Check if item already exists in cart
        boolean found = false;
        for (Cart existingCart : cartList) {
            if (existingCart.getP_id().equals(newCart.getP_id())) {
                // Update quantity
                existingCart.setCount(existingCart.getCount() + newCart.getCount());
                found = true;
                break;
            }
        }
        
        // If not found, add new item
        if (!found) {
            cartList.add(newCart);
        }
        
        return cartList;
    }
    
    /**
     * Remove item from cart or decrease quantity
     */
    public List<Cart> rem2Cart(Cart cartToRemove, List<Cart> cartList) {
        if (cartList == null) {
            return new ArrayList<>();
        }
        
        List<Cart> updatedCart = new ArrayList<>();
        for (Cart existingCart : cartList) {
            if (existingCart.getP_id().equals(cartToRemove.getP_id())) {
                // Decrease quantity
                int newCount = existingCart.getCount() - cartToRemove.getCount();
                if (newCount > 0) {
                    existingCart.setCount(newCount);
                    updatedCart.add(existingCart);
                }
                // If newCount <= 0, don't add to updated cart (effectively removes it)
            } else {
                updatedCart.add(existingCart);
            }
        }
        
        return updatedCart;
    }
}