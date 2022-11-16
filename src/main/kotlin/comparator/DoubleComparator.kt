package comparator

import types.DoubleType
import java.io.Serializable

class DoubleComparator : Comparator, Serializable {
    override fun compare(o1: Any, o2: Any): Double {
        return (o1 as DoubleType).getDoubleTypeValue() - (o2 as DoubleType).getDoubleTypeValue()
    }
}