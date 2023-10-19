package com.lbg.cohort4;

public class PurchasedItem {
    private float cost;
    private int quantity;
    private int vat;


    public PurchasedItem(float cost, int quantity, int vat) {
        this.cost = cost;
        this.quantity = quantity;
        this.vat = vat;
    }

    public float total_price(){
        return (cost + cost*vat/100)*quantity;
    }

}
