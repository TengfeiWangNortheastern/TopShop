package com.mycompany.pojo;

public class CartItem {
    private Product product;
    private int number;
    private double subtotal;

    public double getSubtotal() {
        subtotal=product.getPrice()*number;
        return subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
