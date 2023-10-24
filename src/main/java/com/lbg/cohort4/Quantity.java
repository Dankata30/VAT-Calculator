package com.lbg.cohort4;

import java.util.ArrayList;

public class Quantity implements ParsePrompt {
    private ArrayList<Integer> quantities;
    private String resp;


    public Quantity(){
        this.quantities = new ArrayList<>();
        this.resp = "";
    }

    @Override
    public void parsePrompt() {

        while(true) {
            int quantity = 0;
            String resp = UserInput.take_user_input("\nPlease enter the Quantity of the product: ");

//          Check the response and check if it is a float
            try {
                quantity = Integer.parseInt(resp);
                if(quantity < 0){
                    System.out.println("The quantity should be a positive value.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Incorrect value input. Please give a proper value.");
            }

            quantities.add(quantity);
            setResp(quantity);
            break;
        }

    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    @Override
    public String getResp() {
        return resp;
    }

    public void setResp(Integer cost) {
        this.resp = Integer.toString(cost);
    }
}
