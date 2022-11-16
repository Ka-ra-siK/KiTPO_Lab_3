package types

class PointType {
    private var x = 0.0
    private var y = 0.0

    constructor(x: Double, y: Double){
        this.x = x
        this.y = y
    }
    fun setX(x: Double) {
        this.x = x
    }

    fun getX(): Double {
        return x
    }

    fun setY(y: Double) {
        this.y = y
    }

    fun getY(): Double {
        return y
    }

    override fun toString(): String {
        return "(" + x.toString() +
                ";" + y.toString() + ")"
    }
}