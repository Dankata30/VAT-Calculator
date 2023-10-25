package com.lbg.cohort4;

import java.util.*;

public class Catalogue {
    private HashMap<Integer ,Item> catalogue;

    public Catalogue(){
        this.catalogue = new HashMap<>();
        buildCatalogue();
    }

    private void buildCatalogue(){
        catalogue.put(1, new Item(1,"Iron", 100.00F, 10, 5, true));
        catalogue.put(2, new Item(2,"Toaster", 30.00F, 20, 5, true));
        catalogue.put(3, new Item(3,"Blender", 50.00F, 15, 5, false));
        catalogue.put(4, new Item(4,"Microwave", 150.00F, 10, 5, true));
        catalogue.put(5, new Item(5,"Coffee Maker", 40.00F, 25, 5, false));
    }

    public void showCatalogue(){
        for(Integer idx: catalogue.keySet()){
//            System.out.println(idx + ". " + catalogue.get(idx));
            if(catalogue.get(idx).getQuantity() > 0){
                System.out.println(idx + ". " + catalogue.get(idx));
            }
        }
    }

    public HashMap<Integer ,Item> getCatalogue(){
        return catalogue;
    }
}
