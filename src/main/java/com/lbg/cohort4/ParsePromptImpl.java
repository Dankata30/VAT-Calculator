package com.lbg.cohort4;

import java.util.ArrayList;


public class ParsePromptImpl implements ParsePrompt{
    private TFix fix;

    public ArrayList<Object> getValues() {
        return values;
    }

    private ArrayList<Object> values = new ArrayList<>();

    public ParsePromptImpl( TFix fixer )
    {
        fix = fixer;
    }

    @Override
    public void parsePrompt() {
        while(true) {
            try {
                //Functional interface here
                if(fix.handleCall(values)) break;
            } catch (Exception e) {
                System.out.println("Incorrect value input. Please give a proper value.");
            }
        }
    }

    @Override
    public boolean getResp() {
        return false;
    }
}
