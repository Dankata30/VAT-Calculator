package com.lbg.cohort4;

public class PickItem implements ParsePrompt {

    private String resp;

    public PickItem(){
        this.resp = "";
    }

    @Override
    public boolean parsePrompt(Catalogue cat, Item item) {
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
    }

    @Override
    public String getResp() {
        return resp;
    }
}
