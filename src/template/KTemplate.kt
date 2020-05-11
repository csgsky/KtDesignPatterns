package template


abstract class Cook {
    fun cookProcess() {
        this.pourOil()
        this.heatOil()
        this.pourVegetable()
        this.pourSauce()
        this.fry()
    }
    // 1. 倒油
    fun pourOil() {
        println("倒油")
    }

    // 2. 热油
    fun heatOil() {
        println("热油")
    }

    // 3. 倒菜
    abstract fun pourVegetable()

    // 4. 倒调味料
    abstract fun pourSauce()

    // 5. 炒菜
    fun fry() {
        println("炒菜")
    }
}

class CookBaoCai : Cook() {
    override fun pourVegetable() {
        println("倒入包菜")
    }

    override fun pourSauce() {
        println("倒入干辣椒等")
    }
}

class CookBaicai : Cook() {
    override fun pourVegetable() {
        println("倒入大白菜")
    }

    override fun pourSauce() {
        println("放点小葱花")
    }
}

fun main() {
    val cookBaocai = CookBaoCai()
    val cookBaicai = CookBaicai()
    cookBaicai.cookProcess()
    println("================xxx=============")
    cookBaocai.cookProcess()

}




