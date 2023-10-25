package com.lbg.cohort4;

public class SetWarranty implements ParsePrompt {

    private String resp;

    public SetWarranty(){
        this.resp = "";
    }

    @Override
    public void parsePrompt(Catalogue cat, Item item) {
        if(item.getE_w() == 'n'){
            return;
        }

        while (true) {
            try {
                String resp = UserInput.take_user_input(
                        "The product has an extended warranty. Please specify the time of the warranty (12, 24, 36)");

                int warranty = Integer.parseInt(resp);
//              check if successfully parsed vat is of the correct value
                if (warranty==12 || warranty==24 || warranty==32){
                    // this sets the flag for extended warranty to be set
                    item.setExt_warranty(warranty);
                    break;
                } else {
                    System.out.println("Please enter correct value for warranty!");
                }
            } catch (Exception e) {
                System.out.println("Incorrect value input. Please give a proper value.");
            }
        }
    }

    @Override
    public String getResp() {
        return resp;
    }
}