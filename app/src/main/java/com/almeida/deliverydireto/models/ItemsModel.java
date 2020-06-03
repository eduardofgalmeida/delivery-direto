package com.almeida.deliverydireto.models;

import com.orm.SugarRecord;
import com.orm.dsl.Column;

public class ItemsModel extends SugarRecord {

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
