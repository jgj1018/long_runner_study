package coffeShop;

import coffeShop.actor.Client;
import coffeShop.actor.Shop;
import coffeShop.beverage.Beverage;
import coffeShop.shopdata.MenuInfo;

import java.util.ArrayList;
import java.util.HashMap;

public class test {
    public static void main(String args[]){
        Shop shop = new Shop();
        Client client = new Client();

        ArrayList<HashMap<MenuInfo,Integer>>menu_info_list = shop.makeManulist();
        client.read(menu_info_list);
        MenuInfo order = client.order();
        Beverage beverage = shop.makeBeverage(order);
        client.getBeverage(beverage);
    }

}
