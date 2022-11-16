import gui.GUI
import testing.Testing

fun main(args: Array<String>) {
    val test = Testing()
    val gui = GUI()
    gui.showMenu()
    test.testFloatType()
    test.testPointType()
}