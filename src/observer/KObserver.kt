package observer

import kotlin.properties.Delegates

// 观察者模式
// =====================写法一=======================
/**
 * 观察者
 */
interface Observer {
    fun <T : Any?> update(msg: T)
}

/**
 * 定义具体观察者 1，2，3
 */
class Observer1(private val id: Int = 1) : Observer {
    override fun <T> update(msg: T) {
        println("接收消息，观察者 $id: $msg")
    }
}

class Observer2 : Observer by Observer1(2)
class Observer3 : Observer by Observer1(3)

/**
 * 被观察者
 */
class Subject {
    private var observers = arrayListOf<Observer>()
    fun attach(ob: Observer) {
        observers.add(ob)
    }

    fun <T : Any?> setMsg(msg: T) {
        this.notify(msg)
    }

    private fun <T : Any?> notify(msg: T) {
        for (obj in this.observers) {
            obj.update(msg)
        }
    }
}

// =====================写法二=======================

typealias PropertyChangerLister = (Int) -> Unit

class Property {
    private val listeners = arrayListOf<PropertyChangerLister>()

    var value by Delegates.observable(0) { _, old, new ->
        if(old != new) {
            println("The value was: $old")
            listeners.forEach { listeners -> listeners(new) }
        }
    }

    fun registerListener(listener: PropertyChangerLister) {
        listeners.add(listener)
    }
}


fun main() {
    // 实现一
//    val sub = Subject()
//        .apply {
//            attach(Observer1())
//            attach(Observer2())
//            attach(Observer3())
//        }.apply {
//            setMsg(123)
//            setMsg("hello world")
//            setMsg("A")
//            setMsg(null)
//        }
    // 实现二
    val property = Property()
    property.registerListener { new -> println("the new value is $new") }
    property.value = 10086
    property.value = 10087
}