package com.nursery.app.features.invoice_product.entity;

import com.nursery.app.features.invoice.entity.Invoice;
import com.nursery.app.features.product.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_product")
public class InvoiceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
    @Column(name = "price", columnDefinition = "NUMERIC")
    private Double price;
    @Column(name = "count")
    private Integer count;

    public InvoiceProduct() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
