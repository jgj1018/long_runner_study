package coffeShop.actor;

import coffeShop.beverage.*;
import coffeShop.shopdata.Ingredient;
import coffeShop.shopdata.MenuInfo;

import java.util.ArrayList;
import java.util.HashMap;

import static coffeShop.shopdata.Ingredient.coffebean;
import static coffeShop.shopdata.Ingredient.milk;
import static coffeShop.shopdata.Ingredient.water;

public class Shop {



    public ArrayList<HashMap<MenuInfo,Integer>> makeManulist(){
        ArrayList<HashMap<MenuInfo,Integer>> menual = new ArrayList<HashMap<MenuInfo, Integer>>();
        System.out.println("====================================================");

        for(MenuInfo info : MenuInfo.values()){
            HashMap<MenuInfo,Integer> map = new HashMap<MenuInfo,Integer>();
            map.put(info,info.getPrice());
            menual.add(map);
            System.out.println("매뉴명 : " + info.toString() + "가격 : "+ info.getPrice());
        }

        System.out.println("====================================================");
        return menual;
    }

    public Beverage makeBeverage(MenuInfo order){

        Beverage beverage = null;
        String ingredient = null;
        switch (order){
            case esspresso:
                ingredient = coffebean.toString();
                beverage = new Espresso(ingredient,order.toString(),Integer.toString(order.getPrice()));
                break;
            case americano:
                ingredient = coffebean.toString()+" ,"+water.toString();
                beverage = new Americano(ingredient,order.toString(),Integer.toString(order.getPrice()));
                break;
            case capuchino:
                ingredient = coffebean.toString()+" ,"+water.toString()+" ,"+milk.toString();
                beverage = new Capuchino(ingredient,order.toString(),Integer.toString(order.getPrice()));
                break;
            case cafelatte:
                ingredient = coffebean.toString()+" ,"+water.toString()+" ,"+milk.toString();
                beverage = new CafeLatte(ingredient,order.toString(),Integer.toString(order.getPrice()));
                break;
        }
        return beverage;
    }



}
