package factory

// 简单工厂模式，又称静态工厂方法模式

interface Shape {
    fun draw()
}

class Circle : Shape {
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

// 抽象工厂模式
