package com.lbg.cohort4;

public class Warranty implements ParsePrompt {

    @Override
    public boolean parsePrompt(Catalogue cat, Item item) {
        if(!item.getWarranty()){
            System.out.println("This item has no extended warranty");
            return true;
        }

        while (true) {
            try {
                String resp = UserInput.take_user_input(
                        "The product has an extended warranty. Type Y to apply it and No to ignore");
//              check if successfully parsed vat is of the correct value
                if (resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("n")) {
                    // this sets the flag for extended warranty to be set
                    if(resp.equalsIgnoreCase("y")){
                        item.setE_w('y');
                    }
                    break;
                } else {
                    System.out.println("Please Enter Y or N");
                }
            } catch (Exception e) {
                System.out.println("Incorrect value input. Please give a proper value.");
            }
        }
        return true;
    }

}
