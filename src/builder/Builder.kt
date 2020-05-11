package builder

// Builder 模式

// 实体对象的构建
class Car(
    val model: String?,
    val year: Int
) {
    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {
        var model: String? = null
        var year: Int = -1
        fun build() = Car(model, year)
    }
}


// 通用多样化控件的构建
class Dialog private constructor(
    val title: String,
    val text: String?,
    val onAccept: (() -> Unit)?
) {
    class Builder(val title: String) {
        var text: String? = null
        var onAccept: (() -> Unit)? = null
        fun setText(text: String): Builder {
            this.text = text
            return this
        }

        fun setOnaAccept(onAccept: (() -> Unit)?): Builder {
            this.onAccept = onAccept
            return this
        }

        fun build() = Dialog(title, text, onAccept)
    }
}

fun main() {
//    val car = Car.build {
//        model = "名字"
//        year = 2020
//    }
//    println(car.model)
//    println(car.year)
    val dialog = Dialog.Builder("你好呀")
        .setText("实现四个现代化")
        .setOnaAccept {
            println("是的")
        }.build()


}