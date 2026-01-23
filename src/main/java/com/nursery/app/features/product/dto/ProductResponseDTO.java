package com.nursery.app.features.product.dto;

import com.nursery.app.features.format.dto.FormatResponseDTO;

public class ProductResponseDTO {
    private Integer productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private Integer productCount;
    private Double productHeight;
    private String productHeightUnit;
    private Integer formatId;
    private Boolean active;

    public ProductResponseDTO(){}

    public ProductResponseDTO(Integer productId, String productName, Double productPrice, String productDescription,
                              Integer productCount, Double productHeight, String productHeightUnit,
                              Integer formatId, Boolean active) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCount = productCount;
        this.productHeight = productHeight;
        this.productHeightUnit = productHeightUnit;
        this.formatId = formatId;
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

    public Integer getFormat() {
        return formatId;
    }

    public void setFormat(Integer formatId) {
        this.formatId = formatId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
