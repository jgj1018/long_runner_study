import ingredients.Ingredient
import menu.Recipe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import shop.Stock
import shop.Storage

class MenuTest() {
    private val recipe: Recipe = Recipe()
    private val storage: Storage = Storage()

    @BeforeEach
    fun addIngredients() {
        val ingredientTest1 = Ingredient("Test1", 1.00);
        val ingredientTest2 = Ingredient("Test2", 1.00);
        recipe.addIngredient(ingredientTest1, 1)
        recipe.addIngredient(ingredientTest2, 1)
        storage.addNewStock(Stock(ingredientTest1, 1))
        storage.addNewStock(Stock(ingredientTest2, 2))
    }

    @Test
    fun getTotalIngredientsCostTest() {
        assertEquals(2.00, recipe.getTotalCost())
    }

    @Test
    fun isStockedTestTrue() {
        assertTrue(recipe.canBeMade(storage))
    }
}