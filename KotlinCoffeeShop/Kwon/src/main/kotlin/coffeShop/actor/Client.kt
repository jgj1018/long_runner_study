package coffeShop.actor

import coffeShop.action.ClientInterface
import coffeShop.props.Menu
import coffeShop.shopdata.MenuInfo
import coffeShop.shopdata.MenuType

class Client(): ClientInterface {

    lateinit var menulist : ArrayList<MenuInfo>
    var orderlist : ArrayList<MenuInfo> = ArrayList()
    var productlist : ArrayList<Menu> = ArrayList()
    var money : Int = 0

    constructor(money :Int) : this(){
        this.money = money
    }

    override fun CheckMenu(menulist : ArrayList<MenuInfo>) {
        this.menulist = menulist
    }

    override fun Order() : ArrayList<MenuInfo> {
        var chooseidx:Int = (Math.random() * menulist.size).toInt()
        var ordermenu: MenuInfo? = menulist.get(chooseidx)

        orderlist.add(ordermenu!!)

            if(ordermenu.type == MenuType.FOOD){
                ordermenu = null
                do {
                    chooseidx = (Math.random() * menulist.size).toInt()
                    ordermenu = menulist.get(chooseidx)
                }while (ordermenu != null && ordermenu.type != MenuType.BEVERAGE)

            }else if(ordermenu.type == MenuType.BEVERAGE){
                ordermenu = null
                do {
                    chooseidx = (Math.random() * menulist.size).toInt()
                    ordermenu = menulist.get(chooseidx)
                }while (ordermenu != null && ordermenu.type != MenuType.FOOD)
            }
        orderlist.add(ordermenu!!)

        println("${orderlist.toString()} plz....")

        return orderlist
    }
    //돈은 무조건 지불금액보다 많이 갖고있다고 가정
    //돈모자라면 1개만 시키거나 매뉴다시 확인해서
    //주문 그것도 아니면 그냥 처리 종료 되게
    override fun pay(price : Int) : Int {
        var paymoney =  (Math.random() * (price)).toInt()+500
        this.money = this.money - paymoney
        return paymoney
    }

    override fun getChange(change: Int) {
        this.money = this.money + change
        println("손님이 거스름 돈을 받았다 수중에 남은돈은 ${money}이다")
    }

    override fun getProduct(product: ArrayList<Menu>) {
         productlist = product
        for(product in productlist){
            print("손님은 ${product.name}(${product.hashCode()})을 받는다.")
        }

    }

}