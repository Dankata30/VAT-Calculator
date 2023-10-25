package com.lbg.cohort4;

public class ParsePromptImpl implements ParsePrompt{
    TFix tfix;

    public ParsePromptImpl(TFix tfix){
        this.tfix = tfix;
    }

    @Override
    public boolean parsePrompt(Catalogue cat, Item item) {
        return tfix.promptImpl(cat, item);
    }
}
