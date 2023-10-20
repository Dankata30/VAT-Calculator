package com.lbg.cohort4;

public class Exit implements ParsePrompt {

    private String resp;

    public Exit(){
        this.resp = "";
    }

    @Override
    public void parsePrompt() {
        String resp = UserInput.take_user_input("Do you want to add another product or quit? Type Quit/quit to leave.");
        setResp(resp);
    }

    @Override
    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
         this.resp = resp.toLowerCase();
    }
}
