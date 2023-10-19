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


        while(true){
            if(check_quit("Quit to leave or anything else to get your products")){
                System.out.println("Thanks for using our system! See you soon again!");
                System.exit(0);
            }else{

//                Prompt user to give VAT
                while (correct_value) {
                    vat = (int) take_user_input("VAT");

                    if (vat == 5 || vat == 20) {
                        correct_value = false;
                    } else {
                        System.out.println("VAT not accepted! VAT should be either 5% or 20%!");
                    }
                }

//                    Prompt user to insert prices
                    while (true) {
                        cost = take_user_input("price");
                        PurchasedItem item = new PurchasedItem(cost, 1, vat);

                        items.add(item);

                        if (check_quit("Do you want to add another product or quit? Type Quit to leave.")) {
                            break;
                        }
                    }

                    int counter = 0;
                    if(items.size() > 0){
                        for(PurchasedItem current_item: items){
                            float price = current_item.total_price();
                            System.out.println("The price of product " + counter++ + " is " + price);
                            total_cost+=price;
                        }

                        System.out.printf(String.format("\nThe price of all the objects so far is: %.2f£ \n", total_cost));

                    }
                    counter = 0;
            }
        }
    }

    private static float calculate_total_price(float cost, int vat) {
        return cost + ((cost*vat)/100);
    }

    private static float take_user_input(String operation){
        float result = 0F;
        boolean correct_value = true;

        System.out.printf(String.format("\nPlease enter the %s of the product: ", operation));

        while(correct_value){
            try{
                Scanner sc = new Scanner(System.in);
                result = sc.nextInt();
                correct_value = false;
            }catch(NoSuchElementException e){
                System.out.println("Incorrect value input. Please give a proper value.");
            }
        }

        return result;
    }

    private static boolean check_quit(String prompt){
        System.out.println(prompt);

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(str.isEmpty() || !str.equals("quit")){
            return false;
        }else{
            return true;
        }
    }

}