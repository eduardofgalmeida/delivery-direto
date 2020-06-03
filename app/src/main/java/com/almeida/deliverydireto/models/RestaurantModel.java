package com.almeida.deliverydireto.models;

import com.orm.SugarRecord;
import com.orm.dsl.Column;

import java.util.List;

public class RestaurantModel extends SugarRecord{


    @Column(name= "NAME")
    private String name;

    @Column(name= "DELIVERY_FEE")
    private Double delivery_fee;

    @Column(name= "MINIMUM_ORDER_PRICE")
    private Integer minimum_order_price;


    public RestaurantModel() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(Double delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public Integer getMinimum_order_price() {
        return minimum_order_price;
    }

    public void setMinimum_order_price(Integer minimum_order_price) {
        this.minimum_order_price = minimum_order_price;
    }
}
