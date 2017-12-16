package coffeShop.shopdata

enum class MenuInfo(val price: Int,val discription: String,val type: MenuType) {

    //Bverage
    ESPRESSO(330,"케냐에서 공수한 아름다운 풍미", MenuType.BEVERAGE),
    AMERICANO(340,"윗메뉴에 물탄맛", MenuType.BEVERAGE),
    CafeLatte(400,"윗메뉴에 우유탄맛", MenuType.BEVERAGE),
    Capuchino(420,"윗메뉴에 뭘탄맛", MenuType.BEVERAGE),

    //Food
    BAGEL(200,"밀가루, 소금맛", MenuType.FOOD),
    WAFFLE(200,"와플맛", MenuType.FOOD),
    CHEESECAKE(400,"치즈맛", MenuType.FOOD),
    SANDWICH(300,"한끼식사", MenuType.FOOD)

}