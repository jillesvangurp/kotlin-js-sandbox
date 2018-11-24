package io.inbot.kjs.redom

import org.w3c.dom.Element
import kotlin.js.Json

@JsModule("redom")
external class ReDom {
    companion object {
        fun el(query: String, text: String): Element
        fun el(query: String, vararg elements: Element): Element
        fun el(query: String, elements: List<Element>): Element
        fun el(query: String, json: Json, text: String): Element
        fun el(query: String, json: Json, vararg elements: Element): Element
        fun el(query: String, json: Json, elements: List<Element>): Element
        fun text(str: String): Element
        fun setChildren(parent: Element, vararg children: Element)
    }
}

fun para(vararg elements: Element) = ReDom.el("p", *elements)
fun unorderedList(vararg elements: Element) = ReDom.el("ul", *elements)
fun listItem(vararg elements: Element) = ReDom.el("li", *elements)

fun para(text: String) = ReDom.el("p", text)
fun unorderedList(text: String) = ReDom.el("ul", text)
fun listItem(text: String) = ReDom.el("li", text)
