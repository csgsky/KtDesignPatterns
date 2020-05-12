package factory

// 简单工厂模式，又称静态工厂方法模式

interface Shape {
    fun draw()
}

class Circle : Shape {
    constructor() {
        println("Circle")
    }

    override fun draw() {
        println("draw circle")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("draw rectangle")
    }
}

class KSimpleFactory {
    companion object {
        fun getShape(type: String?): Shape? {
            return when (type) {
                "Circle" -> Circle()
                "Rectangel" -> Rectangle()
                else -> null
            }
        }
    }
}

// 工厂方法模式，又称多态性工厂模式
interface KFactory {
    fun getShape(): Shape
}

class KCircleFactory : KFactory {
    override fun getShape(): Shape {
        return Circle()
    }
}

class KRectangleFactory : KFactory {
    override fun getShape(): Shape {
        return Rectangle()
    }
}

// 抽象工厂模式
/**
 * 生产枪和对应的子弹，枪：AK，M4A1
 */
interface Gun {
    fun shooting()
}

interface Bullet {
    fun load()
}

class AK: Gun {
    override fun shooting() {
        println("shooting with AK")
    }
}

class M4A1 : Gun {
    override fun shooting() {
        println("shooting with M4A1")
    }
}

class AK_Bullet: Bullet {
    override fun load() {
        println("load bullet with AK")
    }
}

class M4A1_Bullet: Bullet {
    override fun load() {
        println("load bullet with M4A1")
    }
}

interface KAbstractFactory {
    fun produceGun(): Gun
    fun produceBullet(): Bullet
}

class AK_Factory: KAbstractFactory {
    override fun produceGun(): Gun {
        return AK()
    }

    override fun produceBullet(): Bullet {
        return AK_Bullet()
    }
}

class M4A1Factory: KAbstractFactory {
    override fun produceGun(): Gun {
        return M4A1()
    }

    override fun produceBullet(): Bullet {
        return M4A1_Bullet()
    }
}





fun main() {
    // 简单工厂
//    KSimpleFactory.getShape("Circle")?.draw()
    // 工厂方法
//    val circleFactory = KCircleFactory()
//    circleFactory.getShape().draw()
    // 抽象工厂
    AK_Factory().produceGun().shooting()
    AK_Factory().produceBullet().load()


}