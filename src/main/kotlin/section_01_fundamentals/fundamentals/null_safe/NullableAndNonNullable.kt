package section_01_fundamentals.fundamentals.null_safe

fun main() {
    // nullable
    var nameNullable: String? = null
    println("Value is : ${nameNullable?.length}") // safe operator ?
    //nameNullable = "Adrian"
    val length = nameNullable?.length ?: 0 // Elvis operator assign a default value ?:
    println("$length")


    nameNullable = "Test"
    println("Value is : $nameNullable")

    // non nullable
    var name: String = "Test"
    // name = null error

    val movie = Movie(null, "Titanic")
    val saveMovie = saveMovie(movie)
    println(saveMovie.id!!) // non null assertions !!
    println("Saved Movie ${saveMovie}")
}

fun saveMovie(movie: Movie): Movie {
    return movie.copy(id = 1)
    //return movie
}

data class Movie(
    val id: Int?,
    val name: String?
) {
}