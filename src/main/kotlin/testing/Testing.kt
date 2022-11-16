package testing

import cycle_list.CycleList
import cycle_list.Iterator
import factory.UserFactory
import types.users.UserType

/**
 * Класс для тестирования.
 * Вывод в консоль трасировки выполнения всех основных методов.
 * @see Testing.testFloatType
 * @see Testing.testPointType
 */
class Testing {
//    private var userFactory: UserFactory? = null
//    private var userType: UserType? = null
//    private var cycleList: CycleList? = null
    fun testFloatType() {
        var userFactory = UserFactory()
        println("\n--------------TEST FOR DOUBLE-------------")
        var userType = userFactory!!.getBuilderByName("Double")
        var cycleList = CycleList(userType!!.getTypeComparator())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        println("---------PRINT CYCLE LIST---------")
        cycleList!!.printList()
        println("-----SAVE TO FILE .DAT----")
        try {
            cycleList!!.save(userType!!, DOUBLE_FILE_SAVE)
            println("Saving is successful!")
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        println("\n----GET NODE BY INDEX 3, 4, 5, 6----")
        System.out.println("3) = " + cycleList!!.getByIndex(3).toString())
        System.out.println("4) = " + cycleList!!.getByIndex(4).toString())
        System.out.println("5) = " + cycleList!!.getByIndex(5).toString())
        System.out.println("6) = " + cycleList!!.getByIndex(6).toString())
        println("\n---DELETE NODE BY INDEX 3, 4, 5, 6--")
        cycleList!!.remove(3)
        cycleList!!.remove(3)
        cycleList!!.remove(3)
        cycleList!!.remove(3)
        cycleList!!.printList()
        println("-----------SORTING----------")
        cycleList!!.sort(userType!!.getTypeComparator())
        cycleList!!.printList()
        println("---LOAD FROM FILE----")
        cycleList!!.load(userType!!, DOUBLE_FILE_SAVE)
        cycleList!!.printList()
        println("---------ITERATOR-----------")
        cycleList!!.forEach(object : Iterator {
            override fun toDo(obj: Any?) {
                val x = obj
                println(x)
            }
        })
        println("---------ITERATOR REVERSE-----------")
        cycleList!!.forEachReverse(object : Iterator {
            override fun toDo(obj: Any?) {
                val x = obj
                println(x)
            }
        })
    }

    fun testPointType() {
        var userFactory = UserFactory()
        println("\n--------------TEST FOR POINT-------------")
        var userType = userFactory!!.getBuilderByName("Point")
        var cycleList = CycleList(userType!!.getTypeComparator())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        cycleList!!.add(userType!!.create())
        println("---------PRINT CYCLE LIST---------")
        cycleList!!.printList()
        println("-----SAVE TO FILE .DAT----")
        try {
            cycleList!!.save(userType!!, POINT_FILE_SAVE)
            println("Saving is successful!")
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        println("\n----GET NODE BY INDEX 3, 4, 5, 6----")
        System.out.println("3) = " + cycleList!!.getByIndex(3).toString())
        System.out.println("4) = " + cycleList!!.getByIndex(4).toString())
        System.out.println("5) = " + cycleList!!.getByIndex(5).toString())
        System.out.println("6) = " + cycleList!!.getByIndex(6).toString())
        println("\n---DELETE NODE BY INDEX 3, 4, 5, 6--")
        cycleList!!.remove(3)
        cycleList!!.remove(3)
        cycleList!!.remove(3)
        cycleList!!.remove(3)
        cycleList!!.printList()
        println("-----------SORTING----------")
        cycleList!!.sort(userType!!.getTypeComparator())
        cycleList!!.printList()
        println("---LOAD FROM FILE----")
        cycleList!!.load(userType!!, POINT_FILE_SAVE)
        cycleList!!.printList()
        println("---------ITERATOR-----------")
        cycleList!!.forEach(object : Iterator {
            override fun toDo(obj: Any?) {
                val x = obj
                println(x)
            }
        })
        println("---------ITERATOR REVERSE-----------")
        cycleList!!.forEachReverse(object : Iterator {
            override fun toDo(obj: Any?) {
                val x = obj
                println(x)
            }
        })
    }

    companion object {
        private const val DOUBLE_FILE_SAVE = "saveDouble.dat"
        private const val POINT_FILE_SAVE = "savePoint.dat"
    }
}