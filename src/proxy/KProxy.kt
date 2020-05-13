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

// =========JDK 动态代理 和 CGLib 动态代理========
/**
 * JDK 动态代理是基于 Java 的反射，必须要实现了接口的类才能用这种方法去代理
 * CGLIB 动态代理是基于 ASM 机制实现，通过生成业务类的子类作为代理类
 *
 * JDK 动态代理的优势：
 * 1. 最小化依赖
 * 2. 代码实现简单
 *
 * CGLib 动态代理的优势：
 * 1. 无需实现接口，达到代理类无侵入
 * 2. 高性能
 * 3. 不关心其他类，只关心我们操作类
 */

fun main() {
    // 静态代理
//    val birdTime = BirdTimeProxy(Bird())
//    birdTime.fly()

}
