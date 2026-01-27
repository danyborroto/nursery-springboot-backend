package com.nursery.app.features.cart_servicio.dto;

public class CartServicioResponseDTO {
    private Integer id;
    private Integer cartId;
    private Integer serviceId;
    private Double price;

    public CartServicioResponseDTO() {
    }

    public CartServicioResponseDTO(Integer id, Integer cartId, Integer serviceId, Double price) {
        this.id = id;
        this.cartId = cartId;
        this.serviceId = serviceId;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
