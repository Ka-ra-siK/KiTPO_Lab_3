package types

class PointType(x: Double, y: Double) {
    private var x = 0.0
    private var y = 0.0

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