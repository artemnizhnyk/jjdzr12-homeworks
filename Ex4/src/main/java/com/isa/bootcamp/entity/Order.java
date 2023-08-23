package com.isa.bootcamp.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Client client;
    private List<MenuItem> menuItems = new ArrayList<>();
    ;

    public Order(Client client) {
        this.client = client;
    }

    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", menuItems=" + menuItems +
                '}';
    }
}
