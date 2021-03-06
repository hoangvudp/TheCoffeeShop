package mum.waa.coffee.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class OrderLine implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Min(value = 1)
    private int quantity;

    @OneToOne
    private Product product;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToOne
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//    public double getSubtotal() {
//        return quantity * product.getPrice().doubleValue();
//    }

//    public double getPrice() {
//        return product.getPrice().doubleValue();
//    }

    @Override
    public String toString() {
        return product.getProductName() + "(" + quantity + ")";
    }
}
