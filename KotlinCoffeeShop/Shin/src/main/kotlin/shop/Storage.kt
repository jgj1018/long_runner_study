package shop

import ingredients.Ingredient

class Storage() {
    private val stockMap = mutableMapOf<String, Stock>()

    fun addNewStock(stock: Stock) {
        stockMap.put(stock.name, stock)
    }

    fun addStock(stock: Stock) {
        if (!stockMap.contains(stock.name)) {
            addNewStock(stock)
        }
        stockMap[stock.name]!!.addUnits(stock.units)
    }

    fun takeStock(stock: Stock) {
        stockMap[stock.name]!!.removeUnits(stock.units)
    }

    fun hasIngredient(nameOfIngredient: String, units: Int): Boolean {
        return stockMap.contains(nameOfIngredient) && stockMap[nameOfIngredient]!!.isCapable(units)
    }

    fun viewStock(nameOfIngredient: String):String = stockMap[nameOfIngredient].toString()
}

class Stock(private val ingredient: Ingredient, var units:Int) {
    val name = ingredient.name

    fun isCapable(need:Int):Boolean {
        return units >= need
    }

    fun addUnits(adder: Int) {
        units += adder
    }

    fun removeUnits(remover: Int) {
        units -= remover
    }
}