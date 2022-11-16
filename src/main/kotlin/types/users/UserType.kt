package types.users

import comparator.Comparator

import java.io.IOException
import java.io.InputStreamReader

interface UserType {
    fun typeName(): String
    fun create(): Any
    fun clone(`object`: Any): Any

    @Throws(IOException::class)
    fun readValue(`in`: InputStreamReader): Any
    fun parseValue(ss: String): Any
    fun getTypeComparator(): Comparator
    fun toString(`object`: Any): String
}