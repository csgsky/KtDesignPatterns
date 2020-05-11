package singleton

import java.io.Serializable

// 单例模式

// 饿汉式
object KSingleton : Serializable {
    fun printSome() {
        println("---- println something ---")
    }
}

// 线程安全的懒汉式
class KLazySingleton private constructor() : Serializable {
    fun doSomething() {
        println("KLazySingleton.doSomething")
    }

    companion object {
        private var mInstance: KLazySingleton? = null
        get() {
            return field ?: KLazySingleton()
        }

        @JvmStatic
        @Synchronized
        fun getInstance(): KLazySingleton {
            return requireNotNull(mInstance)
        }
    }
}

// double check lock
class KLazyDCLSingleton private constructor() : Serializable {

    fun doSomething() {

    }

    companion object {
        @JvmStatic
        val instance: KLazyDCLSingleton by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            KLazyDCLSingleton()
        }
    }
}

fun main() {
    KSingleton.printSome()
    KLazySingleton.getInstance().doSomething()
    KLazyDCLSingleton.instance.doSomething()
}