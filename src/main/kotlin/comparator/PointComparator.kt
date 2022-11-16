package comparator

import types.PointType
import java.io.Serializable

class PointComparator: Comparator, Serializable {

    /**
     * Разница межды объектами вычисляется
     * с помощью разности, между длиннами векторов
     * от заданной точки до цетра координатной оси.
     * Вычисляется по формуле: sqrt(x^2+y^2).
     * @param o1 первая точка
     * @param o2 вторая точка
     * @return разницу между точками
     */
    override fun compare(o1: Any, o2: Any): Double {
        val firstX: Double = (o1 as PointType).getX()
        val secondX: Double = (o2 as PointType).getX()
        val firstY: Double = (o1 as PointType).getY()
        val secondY: Double = (o2 as PointType).getY()
        return getVectorLength(firstX, firstY) - getVectorLength(
            secondX,
            secondY
        )
    }

    /**
     * @param x Точка Х
     * @param y Точка Y
     * @return Длина вектора от точки (x;y) до координатоной оси
     */
    fun getVectorLength(x: Double, y: Double): Double {
        return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0))
    }

}