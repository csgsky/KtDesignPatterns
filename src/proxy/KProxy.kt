package proxy

import java.util.*

/**
 * @Author csgsky
 * @Date 2020/5/13 8:31 下午
 * 代理分为静态代理和动态代理
 */

// ===============静态代理================
/**
 * 静态代理局限性：
 * 1. 如果同时代理多个类，会导致类无限制扩展
 * 2. 如果类中有多个方法需要代理，就会有很多重复的工作
 */
interface Flyable {
    fun fly()
}


class Bird: Flyable {
    // 模拟鸟飞行
    override fun fly() {
        println("Bird is flying....")
        Thread.sleep(Random().nextInt(1000).toLong())
    }
}

class BirdTimeProxy: Flyable {
    var flyable: Flyable? = null
    constructor(flyable: Flyable) {
        this.flyable = flyable
    }
    override fun fly() {
        val start = System.currentTimeMillis()
        println("Start flying.......")
        flyable?.fly()
        val end = System.currentTimeMillis()
        println("end flying.......")
        println("Fly time = ${end - start}")
    }
}

// =================

fun main() {
    val birdTime = BirdTimeProxy(Bird())
    birdTime.fly()
}
