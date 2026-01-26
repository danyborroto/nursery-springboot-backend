package com.nursery.app.features.cart_product.entity;

import com.nursery.app.features.cart.entity.Cart;
import com.nursery.app.features.product.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {
    @EmbeddedId
    private CartProductId cartProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price")
    private Double price;
    @Column(name = "count")
    private Integer quantity;

    public CartProduct(){}

    public CartProduct(CartProductId cartProductId, Cart cart, Product product, Double price, Integer quantity) {
        this.cartProductId = cartProductId;
        this.cart = cart;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public CartProductId getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(CartProductId cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
