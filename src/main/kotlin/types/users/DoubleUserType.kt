package types.users

import comparator.Comparator
import comparator.DoubleComparator
import types.DoubleType
import java.io.InputStreamReader
import java.util.*

/**
 * Интерфейс для создания объектов,
 * вещественное число.
 * @see UserType#typeName() Получение имя типа
 * @see UserType#create() Создание объекта
 * @see UserType#clone(Object) Клонирование текущего объекта
 * @see UserType#readValue(InputStreamReader) Чтение объекта
 * @see UserType#parseValue(String) Парсинг содержимого из стоки, с помощью регулярных выражений
 * @see UserType#getTypeComparator() Получение экземпляра компаратора
 */
class DoubleUserType : UserType{

    private val MAX = 1000.0
    private val MIN = -1000.0

    override fun typeName(): String {
        return "Double"
    }

    override fun create(): Any {
        val random = Random()
        val doubleNum = random.nextDouble(MAX - MIN) + MIN
        return DoubleType(doubleNum)
    }

    override fun clone(`object`: Any): Any {
        return DoubleType((`object` as DoubleType).getDoubleTypeValue())
    }

    override fun readValue(`in`: InputStreamReader): Any {
        return `in`.read()
    }

    override fun parseValue(doubleString: String): Any {
        return DoubleType(doubleString.toDouble())
    }

    override fun getTypeComparator(): Comparator {
        return DoubleComparator()
    }

    override fun toString(`object`: Any): String {
        return `object`.toString()
    }
}