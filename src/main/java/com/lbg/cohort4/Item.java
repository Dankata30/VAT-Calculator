package com.lbg.cohort4;

public class Item {

    private int id;
    private String name;

    private float cost;
    private int quantity;

    private int vat;

    private boolean warranty;


    private char e_w;

    private int ext_warranty;


    public Item(int id, String name , float cost, int quantity, int vat, boolean warranty) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.vat = vat;
        this.warranty = warranty;
        this.e_w = 'n';
        this.ext_warranty = 0;
    }
    @Override
    public String toString(){
       return name + " cost: " + cost + " vat: " + vat + " quantity available: " + quantity
       + " warranty: " + warranty;
    }

    public String audit(){
        String result = name + " total cost: " + cost + " vat: " + vat + " quantity bought: " + quantity;

        if(getE_w() == 'y'){
            result+= " extended warranty of: " + ext_warranty + " months";
        }

        return result;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getVat() {
        return vat;
    }

    public boolean getWarranty() {
        return warranty;
    }

    public int getId() {
        return id;
    }

    public void setE_w(char e_w) {
        this.e_w = e_w;
    }

    public void setExt_warranty(int ext_warranty) {
        this.ext_warranty = ext_warranty;
    }

    public char getE_w() {
        return e_w;
    }

    public int getExt_warranty() {
        return ext_warranty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public float total_price(){
        return (this.getCost() + this.getCost()*this.getVat()/100)*this.getQuantity();
    }
}
