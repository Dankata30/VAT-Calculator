package com.lbg.cohort4;

public class ParserHelper {
    public TFix getPriceHandler()
    {
        TFix fix = (arr)-> {
            String resp = UserInput.take_user_input("\nPlease enter the PRICE of the product: ");
            // Check the response and check if it is a float
            float cost = Float.parseFloat(resp);
            arr.add(cost);

            return true;
        };

        return fix;
    }

    public TFix getVatHandler()
    {
        TFix fix = (vat_values)-> {
            String resp = UserInput.take_user_input("\nPlease enter the VAT of the product: ");
            int vat = 0;
            vat = Integer.parseInt(resp);

            if (vat == 5 || vat == 20) {
                vat_values.add(vat);
                return true;
            } else {
                System.out.println("VAT not accepted! VAT should be either 5% or 20%!");
                return false;
            }
        };

        return fix;
    }

//    public TFix geExitHandler()
//    {
//        TFix fix = (vat_values)-> {
//            String resp = UserInput.take_user_input("Do you want to add another product or quit? Type Quit/quit to leave.");
//            setResp(resp);
//            return true;
//        };
//
//        return fix;
//    }



}
