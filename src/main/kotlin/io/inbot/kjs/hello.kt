import io.inbot.kjs.redom.ReDom.Companion.el
import io.inbot.kjs.redom.ReDom.Companion.setChildren
import io.inbot.kjs.redom.ReDom.Companion.text
import io.inbot.kjs.redom.listItem
import io.inbot.kjs.redom.para
import io.inbot.kjs.redom.unorderedList
import kotlin.browser.document
import kotlin.js.json

fun main(vararg args: String) {
    val body = document.body
        ?: throw IllegalStateException("no body in dom tree, load script inside the body tag and not in the head.")


    val moreStuff = el(".morestuff")
    var counter=1
    setChildren(body, para(text("Some silly things driving redom using kotlin-js")),
        unorderedList(
            listItem(el("b", "foo")),
            listItem(el("a", json("href" to "http://inbot.io", "onClick" to { println("hi")}), "I can has links too")),
            listItem(el("a", json("onclick" to { moreStuff.textContent = "I can has kotlin lambdas as callbacks on links. You clicked me ${counter++} times"}), "Click me"))
        ),
        moreStuff
    )

    // println goes to the console
    println("Hello World from a kotlin println.")


}