package com.nursery.app.features.cart_servicio.entity;

import com.nursery.app.features.cart.entity.Cart;
import com.nursery.app.features.servicio.entity.Servicio;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_services")
public class CartServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Servicio servicio;
    @Column(name = "price", columnDefinition = "NUMERIC")
    private Double price;

    public CartServicio() {}

    public CartServicio(Integer id, Cart cart, Servicio servicio) {
        this.id = id;
        this.cart = cart;
        this.servicio = servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
