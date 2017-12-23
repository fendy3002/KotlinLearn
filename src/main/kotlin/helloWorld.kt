import com.beust.klaxon.*

fun getGreeting(): String {
    val words = mutableListOf<String>()
    words.add("Hello,")
    words.add("world!")

    return words.joinToString(separator = " ")
}

fun parse(name: String) : Any? {
    val cls = Parser::class.java
    return cls.getResourceAsStream(name)?.let { inputStream ->
        return Parser().parse(inputStream)
    }
}

fun main(args: Array<String>) {
    // println(getGreeting())
    val array = parse("/data.json") as JsonArray<JsonObject>

    val ages = array.long("age")
    println("Ages: $ages")
}
