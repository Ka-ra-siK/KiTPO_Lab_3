package types

class DoubleType(doubleTypeValue: Double)  {
    private var doubleTypeValue = 0.0

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