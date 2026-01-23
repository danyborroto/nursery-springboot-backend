package com.nursery.app.features.format.entity;

import com.nursery.app.features.product.entity.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "formats")
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "format_id")
    private Integer formatId;
    @Column(name = "format_name")
    private String formatName;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "format", fetch = FetchType.LAZY)
    private List<Product> productos;

    public Format(){}

    public Format(String formatName, Boolean active){
        this.formatName = formatName;
        this.active = active;
    }

    public Integer getFormatId() {
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
}
