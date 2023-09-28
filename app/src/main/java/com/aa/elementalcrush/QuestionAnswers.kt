package com.aa.elementalcrush

//questions and answer images that are displayed on the screen
class QuestionAnswers {
    //stores all the question and answers as well as the correct answer
    val questions = listOf(
        Question(
            "Hit the Sodium element!",
            listOf("sodium", "sulfur"),
            "sodium"
        ),
        Question(
            "Smash the Hydrogen element!",
            listOf("hydrogen", "mercury"),
            "hydrogen"
        ),
        Question(
            "Crash into Gold element!",
            listOf("silver", "gold"),
            "gold"
        ),
        Question(
            "Destroy the Copper element!",
            listOf("copper", "cobalt"),
            "copper"
        ),
        Question(
            "Hit the Lithium element!",
            listOf("lutetium", "lithium"),
            "lithium"
        ),
        Question(
            "Smash the Livermorium element!",
            listOf("livermorium", "lawrencium"),
            "livermorium"
        ),
        Question(
            "Crash into Carbon element!",
            listOf("chromium", "carbon"),
            "carbon"
        ),
        Question(
            "Destroy the Tin element!",
            listOf("titanium", "tin"),
            "tin"
        ),
        Question(
            "Hit the Bromine element!",
            listOf("bromine", "boron"),
            "bromine"
        ),
        Question(
            "Smash the Tungsten element!",
            listOf("tennessine", "tungsten"),
            "tungsten"
        ),
        Question(
            "Crash into Fluorine element!",
            listOf("fluorine", "iron"),
            "fluorine"
        ),
    )

    //method return an image resource id based on the name specified
    fun getDrawable(answer: String): Int {
        return when (answer) {
            "sodium" -> R.drawable.sodium
            "sulfur" -> R.drawable.sulfur
            "hydrogen" -> R.drawable.hydrogen
            "mercury" -> R.drawable.mercury
            "gold" -> R.drawable.gold
            "silver" -> R.drawable.silver
            "cobalt" -> R.drawable.cobalt
            "copper" -> R.drawable.copper
            "lithium" -> R.drawable.lithium
            "lutetium" -> R.drawable.lutetium
            "livermorium" -> R.drawable.livermorium
            "lawrencium" -> R.drawable.lawrencium
            "chromium" -> R.drawable.chromium
            "carbon" -> R.drawable.carbon
            "titanium" -> R.drawable.titanium
            "tin" -> R.drawable.tin
            "boron" -> R.drawable.boron
            "bromine" -> R.drawable.bromine
            "tungsten" -> R.drawable.tungsten
            "tennessine" -> R.drawable.tennessine
            "iron" -> R.drawable.iron
            "fluorine" -> R.drawable.fluorine
            else -> throw IllegalArgumentException("Invalid answer: $answer")
        }
    }
}