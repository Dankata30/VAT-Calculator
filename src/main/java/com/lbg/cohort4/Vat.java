package com.lbg.cohort4;

import java.util.ArrayList;

public class Vat implements ParsePrompt {
    private ArrayList<Integer> vats;
    private String resp;

    public Vat(){
        this.vats = new ArrayList<>();
        this.resp = "";
    }

    @Override
    public void parsePrompt() {
        while(true){
            String resp = UserInput.take_user_input("\nPlease enter the VAT of the product: ");

            try {
                int vat = 0;
                vat = Integer.parseInt(resp);

//              check if successfully parsed vat is of the correct value
                if (vat == 5 || vat == 20) {
                    vats.add(vat);
                    setResp(vat);
                    break;
                } else {
                    System.out.println("VAT not accepted! VAT should be either 5% or 20%!");
                }
            } catch (Exception e) {
                System.out.println("Incorrect value input. Please give a proper value.");
            }
        }

    }

    public ArrayList<Integer> getVats() {
        return vats;
    }

    @Override
    public String getResp() {
        return resp;
    }

    public void setResp(int vat) {
        this.resp = Integer.toString(vat);
    }
}
