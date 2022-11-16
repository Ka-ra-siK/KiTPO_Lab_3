package types

class DoubleType {
    private var doubleTypeValue = 0.0

    constructor(doubleTypeValue: Double){
        this.doubleTypeValue = doubleTypeValue
    }
    fun getDoubleTypeValue(): Double {
        return doubleTypeValue
    }

    fun setDoubleTypeValue(doubleTypeValue: Double) {
        this.doubleTypeValue = doubleTypeValue
    }

    override fun toString(): String {
        return doubleTypeValue.toString()
    }
}