package com.lbg.cohort4;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput {
    public static String take_user_input(String prompt){
        String result = "";
//        System.out.printf(String.format("\nPlease enter the %s of the product: ", promt));
        System.out.println(prompt);

        Scanner sc = new Scanner(System.in);
        result = sc.nextLine();
        return result;
    }
}
