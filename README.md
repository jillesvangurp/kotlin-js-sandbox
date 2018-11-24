# Introduction

This project is intended as a sandbox for me to learn and document how to do a javascript project using kotlin-js. You may find it useful if like me, you are trying to figure out if this is a good plan at all and are trying to actively minimise your dealings with javascript.

# Show me some code

```kotkin
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
```

# Approach

The approach here is very simple:

- Use the kotlin-frontend-plugin with gradle. I looked at doing this with manually npm/webpack but it looks tedious/painful and mildly underdocumented. Also, the whole point of this is doing things the kotlin way. It seems to do npm and webpack under the hood anyway. If like me, you are used to gradle projects, this is nice. 
- Use intellij for editing files. The latest community edition seems to be able to deal with this project just fine.
- Try interacting with redom. This is an npm module I'm somewhat familiar with as we use it for a lot of stuff in Inbot. 
- Try coming up with some sane abstractions around this stuff so I can prototype some simple UIs quickly without having to worry about a lot of javascript crap. The goal here is being able to write mostly kotlin and not having to deal with a lot of js dependencies.

Short term this is just me fooling around. Mid term, I might do some more serious effort to make this stuff usable. Redom is actually kind of a neat way of doing frontend stuff in javascript if you are trying to dodge the mess that is react or angular. 

IMHO doing react in Kotlin is probably alright but kind of defeats the purpose for me because I then still have to learn React. The only apparent way of doing that is spending a lot of time staring at javascript specific documentation for that and then trying to figure out how to replicate things in Kotlin. Since I've been dealing with redom enough that I know I can get shit done with it, I decided to stick with that.

The good news is that this stuff seems to work reasonably well after figuring out some of the essentials. I still have a few things to figure out but looks like I can do frontend stuff in kotlin using this in a way that seems both idiomatic kotlin and reasonably niceish way of using redom. I still have a lot of question marks though.

# Todo

lots

- Figure out a nice way to do sane MVC style components on top of this
- Deal with storage, http, etc.
- Figure out a sane way of packaging up kotlin-js libraries so they can be used from other kotlin-js projects (npm may not be optimal for that). Jitpack and sourcejar??


# License

[MIT](LICENSE) - feel free to grab whatever you need from this project. 




