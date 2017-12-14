package Common

/**
 * Beverage Enum has two purposes
 * (1) to manage to map between menu_name and menu_id
 * (2) to make code easy to read.
 */
enum class BeverageId (val value: String) {
    Americano("m001"),
    Caffelatte("m002"),
    Espresso("m003"),
    Cappuccino("m004"),
    OrangeJuice("m005"),
}

enum class DessertId (val value: String) {
    CheeseCake("m101")
}