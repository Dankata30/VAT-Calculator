package com.lbg.cohort4;

public class Item {
    private String name;
    private float cost;
    private int quantity;
    private int vat;

    private boolean warranty;


    public Item(String name , float cost, int quantity, int vat, boolean warranty) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.vat = vat;
        this.warranty = warranty;
    }
    @Override
    public String toString(){
       return name + " cost: " + cost + " vat: " + vat + " quantity available: " + quantity
       + " warranty: " + warranty;
    }
}
