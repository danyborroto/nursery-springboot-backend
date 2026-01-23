package com.nursery.app.features.product.entity;

import com.nursery.app.features.format.entity.Format;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price", columnDefinition = "NUMERIC")
    private Double productPrice;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_count")
    private Integer productCount;
    @Column(name = "product_height")
    private Double productHeight;
    @Column(name = "product_height_unit")
    private String productHeightUnit;
    // @Column(name = "format_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "format_id")
    private Format format;
    @Column(name = "active")
    private Boolean active;

    public Product() {
    }

    public Product(String productName, Double productPrice, String productDescription,
                   Integer productCount, Double productHeight, String productHeightUnit, Boolean active) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCount = productCount;
        this.productHeight = productHeight;
        this.productHeightUnit = productHeightUnit;
        this.active = active;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(Double productHeight) {
        this.productHeight = productHeight;
    }

    public String getProductHeightUnit() {
        return productHeightUnit;
    }

    public void setProductHeightUnit(String productHeightUnit) {
        this.productHeightUnit = productHeightUnit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
