package com.lbg.cohort4;

public class PurchasedItem {
    private Item item;


    public PurchasedItem(Item item) {
        this.item = item;
    }

    public float total_price(){
        return (item.getCost() + item.getCost()*item.getVat()/100)*item.getQuantity();
    }

}
