package gui

import cycle_list.CycleList
import factory.UserFactory
import types.users.UserType
import java.awt.Dimension
import java.awt.Font
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.FileNotFoundException
import javax.swing.*
import javax.xml.stream.XMLStreamException

class GUI: JPanel() {
    var userFactory: UserFactory
    var cycleList: CycleList
    var userType: UserType
    private val findBtn: JButton
    private val delBtn: JButton
    private val insertByIdBtn: JButton
    private val insertBtn: JButton
    private val sortBtn: JButton
    private val saveBtn: JButton
    private val loadBtn: JButton
    private val clearBtn: JButton
    
    private val outTextField: JTextArea
    private val delByIdField: JTextField
    private val findByIdField: JTextField
    private val insertByIdField: JTextField
    
    private val findLabel : JLabel
    private val delLabel : JLabel
    private val typeLabel : JLabel
    private val insertLabel : JLabel
    private val createLabel : JLabel
    private val sortLabel : JLabel
    
    private val factoryListItems: JComboBox<*>
    private var defaultType = "Double"
    val FILE_NAME_DOUBLE = "CycleListDouble.dat"
    val FILE_NAME_POINT = "CycleListPoint.dat"

    fun showMenu() {
        val frame = JFrame("MainMenu")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.contentPane.add(GUI())
        frame.pack()
        frame.isVisible = true
    }

    init {
        userFactory = UserFactory()
        userType = userFactory.getBuilderByName("Double")
        cycleList = CycleList(userType!!.getTypeComparator())

        //construct preComponent
        val typeNameList = userFactory.getTypeNameList()
        val factoryListItemsItems = arrayOfNulls<String>(typeNameList.size)
        for (i in typeNameList.indices) {
            factoryListItemsItems[i] = typeNameList[i]
        }

        //construct components
        findBtn = JButton("Найти")
        delBtn = JButton("Удалить")
        insertByIdBtn = JButton("Вставить")
        insertBtn = JButton("Сгенерировать")
        sortBtn = JButton("Сортировать")
        saveBtn = JButton("Сохранить")
        loadBtn = JButton("Загрузить")
        clearBtn = JButton("Очистить")
        findLabel = JLabel("Поиск по индексу")
        delLabel = JLabel("Удалить по индексу")
        typeLabel = JLabel("Тип данных")
        insertLabel = JLabel("Вставка по индексу")
        createLabel = JLabel("Сгенерировать данные")
        sortLabel = JLabel("Сортировка")
        outTextField = JTextArea(5, 5)
        delByIdField = JTextField(5)
        findByIdField = JTextField(5)
        insertByIdField = JTextField(5)
        factoryListItems = JComboBox<Any?>(factoryListItemsItems)

        //adjust size and set layout
        preferredSize = Dimension(600, 563)
        layout = null

        //add components

        //Добавление компонентов
        add(findBtn)
        add(delBtn)
        add(insertByIdBtn)
        add(outTextField)
        add(factoryListItems)
        add(findByIdField)
        add(findLabel)
        add(delByIdField)
        add(delLabel)
        add(typeLabel)
        add(insertLabel)
        add(insertByIdField)
        add(insertBtn)
        add(createLabel)
        add(sortLabel)
        add(sortBtn)
        add(saveBtn)
        add(loadBtn)
        add(clearBtn)

        //set component bounds (only needed by Absolute Positioning)

        //регулировка положения компонентов
        findBtn.setBounds(25, 135, 150, 25)
        delBtn.setBounds(25, 220, 150, 25)
        insertByIdBtn.setBounds(25, 315, 150, 25)
        outTextField.setBounds(190, 20, 345, 525)
        factoryListItems.setBounds(25, 50, 150, 25)
        findByIdField.setBounds(25, 105, 150, 25)
        findLabel.setBounds(25, 85, 150, 20)
        delByIdField.setBounds(25, 190, 150, 25)
        delLabel.setBounds(25, 165, 150, 25)
        typeLabel.setBounds(25, 20, 150, 25)
        insertLabel.setBounds(25, 255, 150, 25)
        insertByIdField.setBounds(25, 280, 150, 25)
        insertBtn.setBounds(25, 435, 150, 20)
        createLabel.setBounds(25, 405, 145, 25)
        sortLabel.setBounds(25, 350, 100, 25)
        sortBtn.setBounds(25, 375, 150, 25)
        saveBtn.setBounds(25, 465, 150, 20)
        loadBtn.setBounds(25, 490, 150, 20)
        clearBtn.setBounds(25, 520, 150, 25)


        //Добавление действий на кнопки
        findBtn.addActionListener { e: ActionEvent? -> findNodeById() }
        delBtn.addActionListener { e: ActionEvent? -> deleteNodeById() }
        insertByIdBtn.addActionListener { e: ActionEvent? -> addNodeById() }
        insertBtn.addActionListener { e: ActionEvent? -> addNode() }
        sortBtn.addActionListener { e: ActionEvent? -> sortList() }
        saveBtn.addActionListener { e: ActionEvent? -> saveList() }
        loadBtn.addActionListener { e: ActionEvent? ->
            try {
                loadList()
            } catch (ex: XMLStreamException) {
                throw RuntimeException(ex)
            } catch (ex: FileNotFoundException) {
                throw RuntimeException(ex)
            }
        }
        clearBtn.addActionListener { e: ActionEvent? -> clearOutTextField() }
        factoryListItems.addActionListener(ActionListener { e: ActionEvent? -> selectTypeList(e) })
        outTextField.isEnabled = true
        outTextField.font = Font("Arial", Font.BOLD, 14)
    }

    private fun selectTypeList(actionEvent: ActionEvent?) {
        val box = actionEvent?.getSource() as JComboBox<*>
        val item = box.selectedItem as String
        if (defaultType !== item) {
            defaultType = item
            userType = userFactory.getBuilderByName(defaultType)
            cycleList = CycleList(userType.getTypeComparator())
            setTextOnOutTextField()
        }

    }

    private fun clearOutTextField() {
        cycleList = CycleList(userType.getTypeComparator())
        setTextOnOutTextField()
    }

    private fun loadList() {
        if (defaultType === "Double") {
            cycleList.load(userType, FILE_NAME_DOUBLE)
            JOptionPane.showMessageDialog(null, "Список успешно загружен!")
            setTextOnOutTextField()
        } else {
            cycleList.load(userType, FILE_NAME_POINT)
            JOptionPane.showMessageDialog(null, "Список успешно загружен!")
            setTextOnOutTextField()
        }
    }

    private fun saveList() {
        if (defaultType === "Double") {
            cycleList.save(userType, FILE_NAME_DOUBLE)
            JOptionPane.showMessageDialog(null, "Список успешно сохранен в \"$FILE_NAME_DOUBLE\"!")
        } else {
            cycleList.save(userType, FILE_NAME_POINT)
            JOptionPane.showMessageDialog(null, "Список успешно сохранен в \"$FILE_NAME_POINT\"!")
        }
    }

    private fun sortList() {
        cycleList.sort(userType.getTypeComparator())
        setTextOnOutTextField()
    }

    private fun addNode() {
        cycleList.add(userType.create())
        setTextOnOutTextField()
    }

    private fun addNodeById() {
        if (insertByIdField.text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Пустое поле! Введите значение!")
            return
        }
        cycleList.add(userType.create(), insertByIdField.text.toInt())
        setTextOnOutTextField()
    }

    private fun deleteNodeById() {
        if (delByIdField.text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Пустое поле! Введите значение!")
            return
        }
        cycleList.remove(delByIdField.text.toInt())
        setTextOnOutTextField()
    }

    private fun findNodeById() {
        if (findByIdField.text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Пустое поле! Введите значение!")
            return
        }
        JOptionPane.showMessageDialog(
            null, "Найденное значение: " +
                    cycleList.getByIndex(findByIdField.text.toInt())
        )
    }

    private fun setTextOnOutTextField() {
        outTextField.text = cycleList.toString()
    }

}