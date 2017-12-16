package menu

import ingredients.Ingredient
import shop.Storage
import kotlin.math.ceil

/*
메뉴의 구성요소는?
 * 메뉴 이름
 * 메뉴의 가격
 * 메뉴의 재료
 * 재료의 사용량
 * 메뉴의 재고 상태(재료가 하나라도 부족하면 재고 부족)
 */

enum class MenuCategory {
    Coffee,
    Beverage,
    Food
}

class Menu(val name:String, val category: MenuCategory) {
    private var recipe:Recipe = Recipe()
    private var margin:Double = 1.3

    fun canBeMade(storage: Storage):Boolean = recipe.canBeMade(storage)

    fun getPrice():Double {
        return ceil(recipe.getTotalCost() * margin)
    }

    fun changeMargin(newMargin : Double) {
        margin = newMargin
    }

    fun setRecipe(recipe: Recipe) {
        this.recipe = recipe
    }

    override fun toString(): String {
        return name
    }
}

class Recipe() {
    private val ingredients = mutableMapOf<Ingredient, Int>()

    fun getTotalCost():Double {
        return ingredients.map { it.key.price }.sum()
    }

    fun addIngredient(ingredient: Ingredient, units: Int) {
        ingredients.put(ingredient, units)
    }

    fun canBeMade(storage: Storage):Boolean = ingredients.all { storage.hasIngredient(it.key.name, it.value) }
}

class MenuList() {
    private var menuList = mutableMapOf<String, Menu>()

    fun sayAllMenu() {
        menuList.forEach { println(it.value.name) }
    }

    fun addMenu(menu: Menu) {
        menuList.put(menu.name, menu)
    }

    fun getMenu(menuName: String):Menu? {
        return menuList[menuName]
    }
}