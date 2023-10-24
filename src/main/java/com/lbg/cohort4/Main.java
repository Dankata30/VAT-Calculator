package com.lbg.cohort4;

import java.util.ArrayList;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<PurchasedItem> items = new ArrayList<>();
        ArrayList<ParsePrompt> prompts = new ArrayList<>();
        Price prices = new Price();
        Vat vats = new Vat();
        Quantity quantities = new Quantity();
        Exit exitObject = new Exit();

        prompts.add(exitObject);
        prompts.add(vats);
        prompts.add(quantities);
        prompts.add(prices);

        Catalogue catalogue = new Catalogue();

        catalogue.showCatalogue();


//        boolean exit = false;
////        use prompts to run the code
//        while(!exit){
//            for(ParsePrompt prompt: prompts){
//                prompt.parsePrompt();
//
////                System.out.println(prompt.getResp());
//                if(prompt.getResp().equals("quit")){
//                    exit=true;
//                    break;
//                }
//            }
//        }
//
//        // create and populate items array list
//        createItems(prices.getPrices(), vats.getVats(), quantities.getQuantities(),items);
//
//        // calculates the values for all items and closes the program
//        disclosePrises(items);
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

    private static void createItems(ArrayList<Float> prices, ArrayList<Integer> vats, ArrayList<Integer> quantities ,ArrayList<PurchasedItem> items) {
        //      take the inserted values for prices and vat

        for(int i=0; i< prices.size(); i++){
            items.add(new PurchasedItem(prices.get(i), quantities.get(i), vats.get(i)));
        }
    }


}

