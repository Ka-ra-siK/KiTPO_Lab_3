package types.users

import comparator.Comparator
import comparator.PointComparator
import types.PointType
import java.io.InputStreamReader
import java.util.*
import java.util.regex.Pattern

class PointUserType: UserType {

    private val MAX = 10.0
    private val MIN = -10.0

    private val REGULAR_EXPRESSION = "\\(([-]?[0-9]+(?:[.,][0-9]+){0,1});([-]?[0-9]+(?:[.,][0-9]+){0,1})\\)"

    override fun typeName(): String {
        return "Point"
    }

    override fun create(): Any {
        val random = Random()
        val x: Double = random.nextDouble(MAX - MIN) + MIN
        val y: Double = random.nextDouble(MAX - MIN) + MIN
        return PointType(x, y)
    }

    override fun clone(`object`: Any): Any {
        return PointType((`object` as PointType).getX(), `object`.getY())
    }

    override fun readValue(`in`: InputStreamReader): Any {
        return `in`.read()
    }

    override fun parseValue(pointString: String): Any {
        val patternString = Pattern.compile(REGULAR_EXPRESSION)
        val matcher = patternString.matcher(pointString)
        if (matcher.find()){
            return PointType((matcher.group(1)).toDouble(), (matcher.group(1)).toDouble())
        }else{
            throw NullPointerException()
        }
    }

    override fun getTypeComparator(): Comparator {
        return PointComparator()
    }

    override fun toString(`object`: Any): String {
        return `object`.toString()
    }
}