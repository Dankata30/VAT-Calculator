package com.lbg.cohort4;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



        ParserHelper ph = new ParserHelper();
        ArrayList<PurchasedItem> items = new ArrayList<>();
        ArrayList<ParsePrompt> prompts = new ArrayList<>();

        // setting the helper lambda functions
        TFix priceHandler = ph.getPriceHandler();
        TFix vatHandler = ph.getVatHandler();
        ParsePromptImpl prices = new ParsePromptImpl(priceHandler);
        ParsePromptImpl vats = new ParsePromptImpl(vatHandler);


        Exit exitObject = new Exit();

        prompts.add(exitObject);
        prompts.add(vats);
        prompts.add(prices);

        // prompting user logic
        promptUser(prompts);

        // create and populate items array list
        createItems(prices.getValues(), vats.getValues(), items);

        // calculates the values for all items and closes the program
        disclosePrises(items);
    }

    private static void disclosePrises(ArrayList<PurchasedItem> items) {
        float total_cost = 0;
        int counter = 1;

        if (items.size() > 0) {
            for (PurchasedItem current_item : items) {
                float price = current_item.total_price();
                System.out.println("The price of product " + counter++ + " is " + price);
                total_cost += price;
            }

            System.out.printf(String.format("\nThe price of all the objects so far is: %.2f£ \n", total_cost));
        }

        System.out.println("Thank you for using our system!");
    }

    private static void createItems(ArrayList<Object> prices, ArrayList<Object> vats, ArrayList<PurchasedItem> items) {
        //      take the inserted values for prices and vat

        for(int i=0; i< prices.size(); i++){
            items.add(new PurchasedItem((float)prices.get(i), 1, (int)vats.get(i)));
        }
    }

    private static void promptUser(ArrayList<ParsePrompt> prompts){
//        use prompts to run the code until user types quit
        while(true){
            for(ParsePrompt prompt: prompts){
                prompt.parsePrompt();

                if(prompt.getResp()) return;
            }
        }
    }
}

