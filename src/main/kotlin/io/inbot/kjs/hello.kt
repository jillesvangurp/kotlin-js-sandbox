import kotlin.browser.document

fun main(vararg args: String) {
    println("hello world. It is me!")

    println(document.all.length)
    repeat(document.all.length) {
        val e = document.all.item(it.toString())
        println(JSON.stringify(e))
        println(e)
    }
    val body = document.body


//    val body = document.getElementById("root")
    if (body != null) {
        val element = document.createElement("div")
        element.textContent = "Hello World"
        body.appendChild(element)
    } else {
        println("wtf")
    }
    println("after")
}