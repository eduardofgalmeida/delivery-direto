package com.almeida.deliverydireto.models;

import com.orm.SugarRecord;
import com.orm.dsl.Column;

import java.util.List;

public class MenuModel extends SugarRecord {

    @Column(name = "NAME")
    public String name;

    @Column(name = "ITEMS")
    public List<ItemsModel> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemsModel> getItems() {
        return items;
    }

    public void setItems(List<ItemsModel> items) {
        this.items = items;
    }
}
