package coffeShop.actor

import coffeShop.action.ShopInterface
import coffeShop.props.Beverage
import coffeShop.props.Food
import coffeShop.props.Menu
import coffeShop.shopdata.Ingredient
import coffeShop.shopdata.MenuInfo
import coffeShop.shopdata.MenuType
import coffeShop.shopdata.Recipe

class Shop():ShopInterface {

    var menulist : ArrayList<MenuInfo>? = ArrayList()
    var orderlist : ArrayList<MenuInfo> = ArrayList()
    var productlist : ArrayList<Menu> = ArrayList()
    var price : Int = 0
    var change : Int =0

    override fun sayHello() {
        println("HELLO 뭐드릴까요? ")
    }

    override fun makeMenuList() : ArrayList<MenuInfo> {
        var menutypewriteflag_food : Boolean = false
        var menutypewriteflag_beverage : Boolean = false

        menulist!!.addAll(MenuInfo.values())

        println("--------[MENU]----------")

        for(menu in menulist!!){

            if(menu.type.equals(MenuType.BEVERAGE) && menutypewriteflag_beverage == false ) {
                println("****[Beverage]****")
                menutypewriteflag_beverage = true
            }
            if(menu.type.equals(MenuType.FOOD)  && menutypewriteflag_food == false){
                println("****[Food]****")
                menutypewriteflag_food = true
            }

            println("name : ${menu.name} , price: ${menu.price} , discription: ${menu.discription}")
        }
        println("------------------------")
        return menulist!!
    }

    override fun getOrder(orderlist : ArrayList<MenuInfo>):Int {

        this.orderlist = orderlist
        for(ordermenu in orderlist){
            println("  ${ordermenu.name} ${ordermenu.price} ")
            price+=ordermenu.price
        }
        println("주문합계 ${price}원 입니다.")
        return price
    }

    override fun getMoney(money: Int) :Int {
        if(price < money){
            change = money - price
            println("${money}원 받았습니다. 거스름돈은 ${change}입니다.")
        }
        return change
    }

    override fun makeMenu() : ArrayList<Menu> {

        for(menu in orderlist){
//            이거왜안됨?
//            when(menu.type){
//                is MenuType.FOOD ->....
//            }
            if(menu.type.equals(MenuType.FOOD)){
                var food = Food(menu.price,
                                menu.discription,
                                menu.type.name,
                                Recipe.valueOf(menu.name).getIngredient().toString(),
                                menu.name)

                productlist.add(food)
                println("${food.name}(${food.hashCode()})을 완성했다.")

            }else if(menu.type.equals(MenuType.BEVERAGE)){

                var beverage = Beverage(menu.price,
                                        menu.discription,
                                        menu.type.name,
                                        Recipe.valueOf(menu.name).getIngredient().toString(),
                                        menu.name)

                productlist.add(beverage)
                println("${beverage.name}(${beverage.hashCode()})을 완성했다.")

            }
        }

        return productlist
    }
}
