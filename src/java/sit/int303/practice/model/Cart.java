/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.practice.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author INT303
 */
public class Cart implements Serializable {
    Map<Integer,LineItem> items = null ;

    public Cart() {
        items = new HashMap<>();
    }
    
    public int getSize() {
        return items.size() ;
    }
    
    public LineItem getItem(int productId) {
        return items.get(productId) ;
    }
    
    public void addItem(int productId) {
        LineItem lit = items.get(productId) ;
        if (lit == null) {
            items.put(productId, new LineItem(productId));
        } else {
            lit.setQuantity(lit.getQuantity()+1);
        }
    }
    
    public void updateItem(int productId, int qty) {
        LineItem lit = items.get(productId) ;
        if (lit == null) {
            items.put(productId, new LineItem(productId, qty));
        } else {
            lit.setQuantity(qty);
        }
    }

    public void remove(int productId) {
        items.remove(productId) ;
    }
    
    public double getTotalPrice() {
        double totalPrice = 0 ;
        for(LineItem lit : items.values()) {
            totalPrice += lit.getTotal() ;
        }
        return totalPrice;
    }

    public Map<Integer, LineItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, LineItem> items) {
        this.items = items;
    }

    public static class LineItem implements Serializable {
        Product product;
        int quantity  ;
        double total ;
        double discount ;

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product p) {
            this.product = p;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
            calculateTotal();
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }
        
        public LineItem(int productId) {
            this(productId, 1) ;
        }
        
        public LineItem(int productId, int qty) {
            quantity = qty ;
            product = Product.findById(productId);
            calculateTotal();
        }
        
        private void calculateTotal() {
            total = product.getPrice() * quantity  ;
            total = total - total * discount ;
        }
    }
    
}
