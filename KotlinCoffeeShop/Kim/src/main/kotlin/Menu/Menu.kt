package Menu

interface Menu {
    val menu_id: String
    val menu_name: String
    val menu_price: Int
    val recipe: Array<String> // not implemented yet regarding recipe

    fun showMenuDetail()
    fun showRecipeDetail()
}




