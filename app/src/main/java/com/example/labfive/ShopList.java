package com.example.labfive;

import java.util.HashMap;

public class ShopList {
    // hashmap allows to store elements using key and value pairs
    // Here, creating a hashmap object called list that stores String keys and Integer values
    public HashMap<String,Integer> list=new HashMap<>();

    // addItem method with item as the parameter
    public void addItem(String item){
        // if the list has the key 'item'
        if(list.containsKey(item)){
            // put the item into the list
            list.put(item, list.get(item)+1);
        }else{
            list.put(item,1);
        }
    }
    public HashMap<String,Integer> getItems(){
        // returning the list
        return list;
    }
}
