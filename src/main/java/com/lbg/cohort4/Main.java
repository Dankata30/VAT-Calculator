package com.lbg.cohort4;


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

        cost = take_user_input("price");

        System.out.println("Price of the product without VAT: " + cost);

        while(correct_value){
            vat = (int)take_user_input("VAT");

            if(vat == 5 || vat == 20 ){
                correct_value = false;
            }else{
                System.out.println("VAT not accepted! VAT should be either 5% or 20%!");
            }
        }

        System.out.println("Product VAT is: " + vat);

        total_cost = calculate_total_price(cost, vat);
        System.out.println(String.format("The VAT paid is: %.2f£. The price of the product with VAT is: %.2f£", cost*vat/100, total_cost));
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
}