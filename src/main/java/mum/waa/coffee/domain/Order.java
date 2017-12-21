package mum.waa.coffee.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4558537476331845667L;

	@Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Order date cannot be empty")
    private Date orderDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();

    @OneToOne
    private Member member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        int quantity = 0;
        for (OrderLine ol : this.orderLines) {
            quantity += ol.getQuantity();
        }
        return quantity;
    }

//    public String getTotalAmount() {
//        double totalAmount = 0;
//
//        for (OrderLine ol : this.orderLines) {
//            totalAmount += ol.getSubtotal();
//        }
//        DecimalFormat format = new DecimalFormat("##.00");
//        return format.format(totalAmount);
//    }

    public void addOrderLine(OrderLine orderLine) {
        orderLine.setOrder(this);
        this.orderLines.add(orderLine);
    }

    public void removeOrderLine(OrderLine orderLine) {
        this.orderLines.remove(orderLine);
        orderLine.setOrder(null);
    }

    public void clearOrderLines() {
        for (OrderLine orderLine : orderLines) {
            orderLine.setOrder(null);
        }
        orderLines.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", orderLines=" + orderLines +
                ", member=" + member +
                '}';
    }
}
