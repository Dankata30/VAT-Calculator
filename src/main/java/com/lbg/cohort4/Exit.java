package com.lbg.cohort4;

public class Exit implements ParsePrompt {

    private String resp;

    public Exit(){
        this.resp = "";
    }

    @Override
    public boolean parsePrompt(Catalogue cat, Item item) {
        String resp = UserInput.take_user_input("Do you want to add another product or quit? Type Quit/quit to leave.");


        if(resp.equals("quit")){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public String getResp() {
        return resp;
    }
}
