package com.issamdrmas.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderMovie {


    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false) 
    private Integer quantity;

    public OrderMovie() {
        super();
    }

    public OrderMovie(Order order, Movie movie, Integer quantity) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setMovie(movie);
        this.quantity = quantity;
    }

    @Transient
    public Movie getMovie() {
        return this.pk.getMovie();
    }

    @Transient
    public Double getTotalPrice() {
        return getMovie().getPrice() * getQuantity();
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderMovie other = (OrderMovie) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }
}
