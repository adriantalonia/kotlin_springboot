package section_01_fundamentals.fundamentals.collections

fun main() {

    //val add = { x: Int -> x + x }  // fun add(x:Int) = x+x

    val addLambda = { x: Int -> x + x }

    val result = addLambda(3)
    println("result: $result")

    val multiplyLambda = { x: Int, y: Int ->
        println("x is $x and y is $y")
        x * y
    }
    val multiplyResult = multiplyLambda(2, 3)
    println("multiplyResult: $multiplyResult")

    val resultCal = calculate(2, 3) { a, b -> a * b }
    println(resultCal)

    val resultCal2 = calculate(2, 3) { a, b -> a + b }
    println(resultCal2)

}


/**
 * Higher order function
 * **/
fun calculate(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}