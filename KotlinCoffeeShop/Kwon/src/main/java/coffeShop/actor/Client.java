package coffeShop.actor;

import coffeShop.beverage.Beverage;
import coffeShop.shopdata.MenuInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Client {

    ArrayList<HashMap<MenuInfo,Integer>> menuinfo;

    public void read( ArrayList<HashMap<MenuInfo,Integer>> menuinfo){
        this.menuinfo = menuinfo;
    }

    public MenuInfo order(){

        int menusize = menuinfo.size();
        int chooseidx = (int)(Math.random()*menusize);
        MenuInfo key = null;
        System.out.println("choose Beverage");

        Set set = menuinfo.get(chooseidx).keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            key = (MenuInfo)iterator.next();
        }

        return key;
    }

    public void getBeverage(Beverage beverage){
        System.out.println("Tank you");
    }



}
