package com.nursery.app.features.cart_product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartProductId implements Serializable {
    @Column(name = "cart_id")
    private Integer cartId;
    @Column(name = "product_id")
    private Integer productId;

    public CartProductId() {
    }

    public CartProductId(Integer cartId, Integer productId) {
        this.cartId = cartId;
        this.productId = productId;
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

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj==null || getClass() != obj.getClass()) return false;
        CartProductId that = (CartProductId) obj;
        if(!Objects.equals(cartId, that.cartId)) return false;
        return Objects.equals(productId, that.productId);
    }
}
