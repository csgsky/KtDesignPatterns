package adapter

/**
 * ================介绍=====================
 * 适配器模式：将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作。
 * 适配器模式可以作为类结构模型，也可以作为对象结构模型。
 *
 * 在适配器模式中，我们一般新增一个适配器类来解决接口不兼容的问题，使原本没有关系的类
 * 可以协作。
 *
 * 根据适配器类和适配者的关系不同，适配器模式可以分为对象适配器和类适配器。
 * 对象适配器：适配器和适配者是关联关系
 * 类适配器：适配器和适配者是继承（实现）关系
 *
 * ==============角色======================
 * 目标抽象类（Target）: 客户希望的接口
 * 适配器（Adapter）: 适配器
 * 适配者类（Adaptee）: 被适配的角色
 */

// 类适配器
open class Adaptee {
    fun adapteeRequest() {
        println("被适配者的方法")
    }
}

interface Target {
    fun request()
}

class KClassAdapter: Adaptee(), Target {
    override fun request() {
        println("======= 一些其他操作 1==========")
        super.adapteeRequest()
        println("======= 一些其他操作 2==========")
    }
}

// 对象适配器
class KObjectAdapter: Target {
    val adaptee = Adaptee()
    override fun request() {
        println("======= 一些其他操作 1==========")
        adaptee.adapteeRequest()
        println("======= 一些其他操作 2==========")
    }
}

fun main() {
    val adapter = KClassAdapter()
    adapter.request()
    val adapter1 = KObjectAdapter()
    adapter1.request()
}

