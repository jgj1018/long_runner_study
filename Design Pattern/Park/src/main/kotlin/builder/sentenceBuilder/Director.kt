package builder.sentenceBuilder

import builder.sentenceBuilder.apiLevel.Builder

class Director(val builder:Builder) {

    fun construct(){
        builder.makeTitle("Greeting")
        builder.makeString("from morning to afternoon")
        builder.makeItems(arrayOf(
                "Good morning",
                "Good afternoon"
        ))

        builder.makeString("in the evening")
        builder.makeItems(arrayOf(
                "Good evening",
                "Good night",
                "Bye"
        ))
        builder.close()

    }

}