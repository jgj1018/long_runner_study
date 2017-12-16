package coffeShop.shopdata

enum class Recipe {

    ESPRESSO{
        val water = Ingredient.WATER
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
                recipe.add(Ingredient.COFFEBEAN.name)
            return recipe
        }
    },
    AMERICANO {
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
            recipe.add(Ingredient.WATER.name)
            recipe.add(Ingredient.COFFEBEAN.name)
            return recipe
        }

    },
    CafeLatte {
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
            recipe.add(Ingredient.WATER.name)
            recipe.add(Ingredient.COFFEBEAN.name)
            recipe.add(Ingredient.MILK.name)
            return recipe
        }
    },
    Capuchino {
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
            recipe.add(Ingredient.WATER.name)
            recipe.add(Ingredient.COFFEBEAN.name)
            recipe.add(Ingredient.MILK.name)
            recipe.add(Ingredient.CHOCOPOUDER.name)
            return recipe
        }
    },
    BAGEL {
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
            recipe.add(Ingredient.SALT.name)
            recipe.add(Ingredient.FLOUR.name)
            return recipe
        }
    },
    WAFFLE {
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
            recipe.add(Ingredient.FLOUR.name)
            recipe.add(Ingredient.MAYPLESEROUP.name)
            return recipe
        }
    },
    CHEESECAKE {
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
            recipe.add(Ingredient.FLOUR.name)
            recipe.add(Ingredient.CHOCOPOUDER.name)
            return recipe
        }
    },
    SANDWICH {
        override fun getIngredient(): ArrayList<String> {
            var recipe : ArrayList<String> = ArrayList()
            recipe.add(Ingredient.FLOUR.name)
            recipe.add(Ingredient.EGG.name)
            recipe.add(Ingredient.CABBAGE.name)
            return recipe
        }
    };

    abstract fun getIngredient(): ArrayList<String>
}