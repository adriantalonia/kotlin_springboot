package section_01_fundamentals.fundamentals.conditionals

fun main() {

    // if-else
    // when

    val name = "Adrian"
    if (name.length == 4) {
        println("Name is four caracters")
    } else {
        println("Name is not four characters")
    }

    val result = if (name.length == 4) {
        println("Name is four caracters")
        name
    } else {
        println("Name is not four characters")
        name
    }

    println("result: $result")

    val position = 1
    val medal = if(position == 1) {
        "GOLD"
    } else if(position == 2) {
        "SILVER"
    } else if(position == 3) {
        "BRONZE"
    } else {
        "NO MEDAL"
    }

    println(medal)

    val medal2 = when (4) {
        1 -> {
            "GOLD"
        }
        2 -> {
            "SILVER"
        }
        3 -> {
            "BRONZE"
        }
        else -> {
            "NO MEDAL"
        }
    }

    println(medal2)


}