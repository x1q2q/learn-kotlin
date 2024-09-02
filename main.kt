
fun main(){
    // packages using camelcase

    // #VARIABLES
    // val to declare read-only variable (immutable),seems like `final`
    // var to declare mutable variable
    // common type data `Int`, `Double`, `String`, `Boolean`
    val username: String = "Rafiknurf"
    var age : Int = 22
    println("The age before is $age")
    age = 23
    println(username)
    // call Function
    println(greeting("ini adalah pesan singkat"))
    // #STRING TEMPLATES
    // use $ and ${} for operation
    println("The age of person  $username now is ${age +1}") // 24
    
    // #BASIC TYPES
    var customers = 10
    customers = customers + 3 // cth penambahan 3 => 13
    customers -= 4 // cth. pengurangan 4 => 9
    customers /= 3 // cth. pembagian 3 => 3
    println("Now the customers is $customers")
    val total: Int = 1000; val totalB : Int = 2000 // also Byte, Short, Long
    val message: String = "Log message"
    val pi: Double = 3.14 // also Float
    val countmoney : Long = 100_000_000_000_000
    val whatever : Any // avoid this
    val isAccepted: Boolean = true // true or false
    val character: Char = '\n'

    println("$character $message - ${total + totalB}")
    
    // multi-line literal strings
    val multiline = """
        {
        "name":"Max"
        }
    """.trimIndent()

    println(multiline)

    // Control Flow (IF)
    if(totalB>total && isAccepted){
        println(pi)
        println(countmoney)
    }
    var tax = 0;
    while(tax < 10){
        tax++
    }
    println("Now the tax is $tax")

    // conditionals are expressions; replaces the ternary operator from other language
    val result = if(tax>8) "its high tax" else "oh, low tax"
    println("Tax result: $result")
    // can call a function inside the function
    println(if(tax<7) "the tax less tan 7" else "more or equals to 8")
    
    // `when`, replacesthe `switch` from other languages
    var price: Any = 2
    println("Calculating the price")
    when(price){
        0 -> println("No price")
        1 -> {
            print("That's")
            print("So cheap")
        }
        in 2..10 -> println("still cheap honey")
        11,12,13,14 -> println("Oh, getting expensive")
        is String -> println("Cant recognition the parameters")
        else -> println("Expensive buddy!")
    }
    // Loops
    // while(true){}
    for(i in 1..10){
        println(i)
    }

    // # Collections
    // Lists, we use List<Type> and the type of the collection inside the generic
    // The Literal uses the listOf constructor -> return the list
    // default of listOf is IMMUTABLE
    val countries = listOf("Indonesa","Timor Leste","Papua New Guinea")

    // default of mutableListOf is MUTABLE
    val cities = mutableListOf("Malaysia","Singapore","Thailand")
    cities.add("Philiphines")
    println(cities)

    // we also have sets and maps (dictionaries)
    // when we talk to the Android SDK sometime we need to use Java Arrays (if we low level)
    val strings = hashSetOf("a","b","c","d") // unique -> can duplicate data
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    val javaArray = arrayOf(countries)
    println(strings)
    println(readWriteMap)
    println(javaArray)
    
    // # NULL-SAFETY
    var nameWithNulls: String? = null // use `?` marks (accept null)
    // print(nameWithNulls.length) => it doesn't work
    
    val len= if(nameWithNulls != null ) nameWithNulls.length else 0
    print(len)
    // not-null assertion operatore
    // val lengthForSure = nameWithNulls!!.length // => use double `!` bu avoid this
    // print(lengthForSure)

    // safe calls
    var length = nameWithNulls?.length
    print(length)
    // default values
    // val lengthOrDefault = name?.count ?: 0 // what's the name of the `?:` operator? (elvis operator)
    aFunction()
    println(aFunctionReturning2())
    println(sum(10,20))
    // or like this
    println(sum(b=6,a=4))
    // or like this
    println(sum3(4,c=6,b=2))
    // extension function
    println(2.isEven())
}
// void function
fun aFunction(){
    println("Its a void function")
}
// returning function
fun greeting(message: String): String{
    return "Hello, $message"
}

fun aFunctionReturning2(): String = "Just a function"

// with arguments
fun sum(a: Int, b:Int): Int{
    return a+b
}
// with arguments
fun sum3(a:Int, b:Int, c:Int):Int{
    return a+b+c
}

// extension function
// way to inject, to add a new function to any object/time
fun Int.isEven(): Boolean{
    return this % 2 == 0
}

/*: * lambda functions, type is (arguments) -> returnType
    if no return is expected, we use unit
*/
// val myLambdaFunction: () -> Unit{
//     // a void function
//     println("Its void")
// }
val myLambda2Function: (Int, Boolean) -> Unit = { int, isReady ->
    println(isReady, int)
}

// implicit `it` arguemnt when there is only one argument
// you can still name it if you want to
val greet : (String) -> String
greet = {
    return "Hello, $it"
}

val myCalc : (Int, Int) -> Int = a,b -> {a+b}

// constant names are using UPPER_SNAKE_CASE
object List{
    const val MAX_LENGTH = 4
}

// Data Types use TitleCase.
// TitleCase also applies to Singleton variables and Objects!
class CustomOrder{}
object MyObject{}
interface MyInterface{}
//  val SingletonInstance : Any = TODO()

