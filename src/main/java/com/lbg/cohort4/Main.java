package com.lbg.cohort4;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        float cost = 0;
        int vat = 0;
        float total_cost = 0;
        boolean correct_value = true;
        ArrayList<PurchasedItem> items = new ArrayList<>();


        while (true) {
//          Prompt user to choose to quit or add new products
            String resp = UserInput.take_user_input("Quit to leave or anything else to get your products");
            if (resp.equals("quit")) {
                System.out.println("Thanks for using our system! See you soon again!");
                System.exit(0);
            } else {

//              Prompt user to give VAT
                while (correct_value) {
                    resp = UserInput.take_user_input("Please enter the VAT of the product: ");

                    try {
                        vat = Integer.parseInt(resp);

//                        check if successfully parsed vat is of the correct value
                        if (vat == 5 || vat == 20) {
                            correct_value = false;
                        } else {
                            System.out.println("VAT not accepted! VAT should be either 5% or 20%!");
                        }
                    } catch (Exception e) {
                        System.out.println("Incorrect value input. Please give a proper value.");
                    }

                }

//                    Prompt user to insert prices
                while (true) {
                    resp = UserInput.take_user_input("Please enter the price of the product: ");

//                      try and parse a float value for the cost of the object
                    try {
                        cost = Float.parseFloat(resp);
                    } catch (Exception e) {
                        System.out.println("Incorrect value input. Please give a proper value.");
                    }

                    items.add(new PurchasedItem(cost, 1, vat));

                    resp = UserInput.take_user_input("Do you want to add another product or quit? Type Quit to leave.");

                    if (resp.equals("quit")) {
                        break;
                    }
                }

                int counter = 0;
                if (items.size() > 0) {
                    for (PurchasedItem current_item : items) {
                        float price = current_item.total_price();
                        System.out.println("The price of product " + counter++ + " is " + price);
                        total_cost += price;
                    }

                    System.out.printf(String.format("\nThe price of all the objects so far is: %.2f£ \n", total_cost));

                }
                counter = 0;
            }
        }
    }
}