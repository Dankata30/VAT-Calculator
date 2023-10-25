package com.lbg.cohort4;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<ParsePrompt> prompts = new ArrayList<>();
        Catalogue catalogue = new Catalogue();

        CreateLambdas pimpl = new CreateLambdas();
        ParsePromptImpl exitObject = new ParsePromptImpl(pimpl.quit());
        ParsePromptImpl pickItem = new ParsePromptImpl(pimpl.pickItem());
        ParsePromptImpl quantities = new ParsePromptImpl(pimpl.quantity());
        ParsePromptImpl extended_warranty = new ParsePromptImpl(pimpl.warranty());
        ParsePromptImpl set_warranty = new ParsePromptImpl(pimpl.setWarranty());

        prompts.add(exitObject);
        prompts.add(pickItem);
        prompts.add(quantities);
        prompts.add(extended_warranty);
        prompts.add(set_warranty);


        boolean exit = true;
//        use prompts to run the code
        while(exit){
            Item item = new Item(0, "", 0, 0,0,false);
            for(ParsePrompt prompt: prompts){
                exit = prompt.parsePrompt(catalogue, item);

                if(!exit) break;
            }

            if(item.getId() != 0){
                items.add(item);
            }else{
                break;
            }
        }

//        // calculates the values for all items and closes the program
        disclosePrises(items);
    }

    private static void disclosePrises(ArrayList<Item> items) {
        float total_cost = 0;

        if (items.size() > 0) {
            for (Item current_item : items) {
                float price = current_item.total_price();
                System.out.println(current_item.audit());
                total_cost += price;
            }

            System.out.printf(String.format("\nThe price of all the objects so far is: %.2f£ \n", total_cost));
        }

        System.out.println("Thank you for using our system!");
    }


}

