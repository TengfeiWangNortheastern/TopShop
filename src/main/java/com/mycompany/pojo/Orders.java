package com.mycompany.pojo;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Orders {
    private int id;
    private int userId;
    private String shippingAddress;
    private String recipientName;
    private String recipientPhone;
    private String payment;
    private double total;
    private String status;
    private Timestamp time;

    private List<Orderitem> orderitems;
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "shipping_address")
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Basic
    @Column(name = "recipient_name")
    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @Basic
    @Column(name = "recipient_phone")
    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    @Basic
    @Column(name = "payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "total")
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (userId != orders.userId) return false;
        if (Double.compare(orders.total, total) != 0) return false;
        if (shippingAddress != null ? !shippingAddress.equals(orders.shippingAddress) : orders.shippingAddress != null)
            return false;
        if (recipientName != null ? !recipientName.equals(orders.recipientName) : orders.recipientName != null)
            return false;
        if (recipientPhone != null ? !recipientPhone.equals(orders.recipientPhone) : orders.recipientPhone != null)
            return false;
        if (payment != null ? !payment.equals(orders.payment) : orders.payment != null) return false;
        if (status != null ? !status.equals(orders.status) : orders.status != null) return false;
        if (time != null ? !time.equals(orders.time) : orders.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + userId;
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        result = 31 * result + (recipientName != null ? recipientName.hashCode() : 0);
        result = 31 * result + (recipientPhone != null ? recipientPhone.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }
}
