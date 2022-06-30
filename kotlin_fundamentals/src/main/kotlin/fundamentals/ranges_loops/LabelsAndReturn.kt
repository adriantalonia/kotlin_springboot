package section_01_fundamentals.fundamentals.ranges_loops

fun main() {

    for (i in 1..5) {
        println("i in $i")
        if (i == 3) break
    }

    println("End of the Program!")

    label()
}

fun label() {
    loop@ for (i in 1..5) {
        println("i in label $i")
        innerLoop@ for (j in 1..5) {
            println("j in label $j")
            //if (j == 2) break@innerLoop
            if (j == 2) continue@innerLoop
        }
    }

    listOf(1,2,3,4,5).forEach each@ {
        println(it)
        if(it ==3) return@each
    }
}