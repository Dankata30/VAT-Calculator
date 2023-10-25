package com.lbg.cohort4;

public class PromptImplementations {

    public TFix pickItem(){

        TFix tfix = (cat, item) ->{
            cat.showCatalogue();


            while (true) {
                try {
                    String resp = UserInput.take_user_input(
                            "Please type the id of the product you want to buy");

                    int id = 0;
                    id = Integer.parseInt(resp);

//              check if item id exists in the catalogue
                    if (cat.getCatalogue().containsKey(id)) {
                        // create a product
                        Item temp = cat.getCatalogue().get(id);

                        item.setId(temp.getId());
                        item.setName(temp.getName());
                        item.setCost(temp.getCost());
                        item.setVat(temp.getVat());
                        item.setWarranty(temp.getWarranty());

                        System.out.println("You added " + item.getName() + " to your basket.");
                        break;
                    } else {
                        System.out.println("No such item exists. Please select a correct id.");
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect value input. Please give a proper value.");
                }
            }
            return true;
        };

        return tfix;
    }

    public TFix quantity() {

        TFix tfix = (cat, item) -> {
            while (true) {
                int quantity = 0;

//          Check the response and check if it is a int
                try {
                    String resp = UserInput.take_user_input("\nPlease enter the Quantity of the product to buy: ");

                    quantity = Integer.parseInt(resp);

                    if (quantity < 0) {
                        System.out.println("The quantity should be a positive value.");
                        continue;
                    }

                    Item temp = cat.getCatalogue().get(item.getId());

                    if (temp.getQuantity() < quantity) {
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
        };

        return tfix;
    }

    public TFix warranty() {

        TFix tfix = (cat, item) -> {
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
        };

        return tfix;
    }

    public TFix setWarranty() {

        TFix tfix = (cat, item) -> {
            if(item.getE_w() == 'n'){
                return true;
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
            return true;
        };

        return tfix;
    }

    public TFix quit() {

        TFix tfix = (cat, item) -> {
            String resp = UserInput.take_user_input("Do you want to add another product or quit? Type Quit/quit to leave.");

            return !resp.equals("quit");
        };

        return tfix;
    }

}
