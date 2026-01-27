package com.nursery.app.features.servicio.entity;

import com.nursery.app.features.cart_servicio.entity.CartServicio;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "selectable")
    private Boolean selectable;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "servicio",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartServicio> cartServicios;

    public Servicio() {}

    public Servicio(Integer serviceId, String serviceName, Boolean selectable, Boolean active, List<CartServicio> cartServicios) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.selectable = selectable;
        this.active = active;
        this.cartServicios = cartServicios;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<CartServicio> getCartServicios() {
        return cartServicios;
    }

    public void setCartServicios(List<CartServicio> cartServicios) {
        this.cartServicios = cartServicios;
    }
}
