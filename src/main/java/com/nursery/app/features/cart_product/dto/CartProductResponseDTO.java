package com.nursery.app.features.cart_product.dto;

public class CartProductResponseDTO {
    private Integer cartId;
    private Integer productId;
    private Double price;
    private Integer quantity;

    public CartProductResponseDTO() {}

    public CartProductResponseDTO(Integer cartId, Integer productId, Double price, Integer quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}