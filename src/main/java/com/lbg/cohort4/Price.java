package com.lbg.cohort4;

import java.util.ArrayList;

public class Price implements ParsePrompt {

    private ArrayList<Float> prices;
    private String resp;


    public Price(){
        this.prices = new ArrayList<>();
        this.resp = "";
    }

    @Override
    public void parsePrompt() {

        while(true) {
            float cost = 0F;
            String resp = UserInput.take_user_input("\nPlease enter the PRICE of the product: ");

//          Check the response and check if it is a float
            try {
                cost = Float.parseFloat(resp);
            } catch (Exception e) {
                System.out.println("Incorrect value input. Please give a proper value.");
            }

            prices.add(cost);
            setResp(cost);
            break;
        }

    }

    public ArrayList<Float> getPrices() {
        return prices;
    }

    @Override
    public String getResp() {
        return resp;
    }

    public void setResp(Float cost) {
        this.resp = Float.toString(cost);
    }
}
