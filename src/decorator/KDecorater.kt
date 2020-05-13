package decorator

import decorator.FilterCook as DecoratorFilterCook

/**
 * @Author csgsky
 * @Date 2020/5/13 3:47 下午
 * 装饰器模式：又称为包装模式，装饰器模式以多客户端透明的方式扩展对象的功能，是继承关系的一个替代方案
 */

interface Cook {
    fun cookDinner()
}

class ChineseCook : Cook {
    override fun cookDinner() {
        println("中国人做晚饭")
    }
}

abstract class FilterCook : Cook {
    var cook: Cook? = null
}

class WashHandCook : DecoratorFilterCook {
    constructor(cook: Cook) {
       this.cook = cook
    }
    override fun cookDinner() {
        println("先洗洗手")
        cook?.cookDinner()
    }
}

class WashHeadCook : DecoratorFilterCook {
    constructor(cook: Cook) {
        this.cook = cook
    }
    override fun cookDinner() {
        println("先洗洗头")
        cook?.cookDinner()
    }
}

fun main() {
    val cook0 = WashHandCook(ChineseCook())
    val cook1 = WashHeadCook(ChineseCook())
    cook0.cookDinner()
    cook1.cookDinner()
}






