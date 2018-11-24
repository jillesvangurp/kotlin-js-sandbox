import io.inbot.kjs.redom.ReDom.Companion.el
import io.inbot.kjs.redom.ReDom.Companion.setChildren
import io.inbot.kjs.redom.ReDom.Companion.text
import io.inbot.kjs.redom.listItem
import io.inbot.kjs.redom.para
import io.inbot.kjs.redom.unorderedList
import kotlin.browser.document
import kotlin.js.json

@JsModule("is-positive")
external fun isPositive(number: Int): Boolean

fun main(vararg args: String) {
    val body = document.body
        ?: throw IllegalStateException("no body in dom tree, load script inside the body tag and not in the head.")


    setChildren(body, para(text("bar")),
        unorderedList(
            listItem(el("b", "foo")),
            listItem(el("a", json("href" to "http://inbot.io"), "I can has links too"))
        )

    )

    println("a console message should appear")


}