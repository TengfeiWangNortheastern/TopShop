package com.mycompany.pojo;

import org.hibernate.criterion.Order;

import javax.persistence.*;

@Entity
public class Orderitem {
    private int id;
    private Double subtotal;
    private Integer productId;
    private Orders order;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subtotal")
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Basic
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderitem orderitem = (Orderitem) o;

        if (id != orderitem.id) return false;
        if (subtotal != null ? !subtotal.equals(orderitem.subtotal) : orderitem.subtotal != null) return false;
        if (productId != null ? !productId.equals(orderitem.productId) : orderitem.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
    @ManyToOne
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
