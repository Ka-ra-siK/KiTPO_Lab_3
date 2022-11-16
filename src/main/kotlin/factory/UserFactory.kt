package factory

import types.users.DoubleUserType
import types.users.PointUserType
import types.users.UserType
import java.util.*

class UserFactory {
    private var typeList : List<UserType> = listOf(DoubleUserType(), PointUserType())

    fun getTypeNameList(): List<String>{
        var listOfType: List<String> = listOf()
        for (t in typeList){
            listOfType +=  t.typeName()
        }
        return listOfType
    }

    fun getBuilderByName(name: String): UserType{
        if (name == null) throw NullPointerException()
        for (userType in typeList){
            if (name == userType.typeName())
                return userType
        }
        throw IllegalArgumentException()
    }

}