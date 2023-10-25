package com.lbg.cohort4;

import java.util.ArrayList;

public class Quantity implements ParsePrompt {
    private String resp;


    public Quantity(){
        this.resp = "";
    }

    @Override
    public boolean parsePrompt(Catalogue cat, Item item) {

        while(true) {
            int quantity = 0;

//          Check the response and check if it is a int
            try {
                String resp = UserInput.take_user_input("\nPlease enter the Quantity of the product to buy: ");

                quantity = Integer.parseInt(resp);

                if(quantity < 0){
                    System.out.println("The quantity should be a positive value.");
                    continue;
                }

                Item temp = cat.getCatalogue().get(item.getId());

                if(temp.getQuantity() < quantity){
                    System.out.println("The quantity exceeds the available stock.");
                    continue;
                }

                item.setQuantity(quantity);
                // update catalogue for current item with appropriate quantity
                cat.getCatalogue().put(temp.getId(), new Item(temp.getId(), item.getName(), item.getCost(),
                        temp.getQuantity() - quantity, item.getVat(), item.getWarranty()));
                break;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Incorrect value input. Please give a proper value.");
            }
        }
        return true;
    }

    @Override
    public String getResp() {
        return resp;
    }

    public void setResp(Integer cost) {
        this.resp = Integer.toString(cost);
    }
}
