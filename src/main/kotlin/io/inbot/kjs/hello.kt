import org.w3c.dom.HTMLElement
import kotlin.browser.document

@JsModule("is-positive")
external fun isPositive(number: Int): Boolean

//@JsModule("redom")
//@JsNonModule
//external fun el(tagName: String, argument: Array<Any>): HTMLElement

@JsModule("redom")
external class ReDom {
    companion object {
        fun el(query: String, vararg args: Any): HTMLElement
        fun text(str: String): HTMLElement
    }

}


fun main(vararg args: String) {
    val body = document.body

    if (body != null) {
        val element = document.createElement("div")
        element.textContent = "Is it positive? -1:${isPositive(-1)} or 1:${isPositive(1)}?"
        body.appendChild(element)
        body.appendChild(ReDom.el(".foo",ReDom.text("foo")))

//        val node = text("yes")
//        element.appendChild(node)
//        body.appendChild(text("i can has redom"))
    } else {
        println("wtf")
    }
    println("after")


}