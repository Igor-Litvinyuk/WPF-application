import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    //Объявляем и инициализируем необходимые поля:
    private MainWindow parent;
    private Model model = new Model();

    //Создаем конструктор:
    public Controller(MainWindow parent) {
        this.parent = parent;
    }

    //Обрабатываем нажатия мышкой на кнопки:
    /**
     * - При нажатии на кнопку Add Employee будет создаваться новое окно, в котором нужно
     * ввести имя, фамилию, id, дату рождения нового работника и указать активен ли он.
     * - При нажатии на кнопку Remove Employee будет создаваться новое окно, в котором нужно
     * ввести id работника, которого нужно удалить.
     * - При нажатии на кнопку Get all employees в консоль будет выводиться
     * список всех работников, отсортированных в алфавитном порядке по имени и фамилии.
     * - При нажатии на кнопку Get active employees в консоль будет выводиться
     * список всех активных работников, отсортированных в алфавитном порядке по имени и фамилии.
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == parent.buttonAddE) {
            AddWindow addParent = new AddWindow();
            addParent.createAddFrame();
        }
        if (src == parent.buttonRemoveE) {
            RemoveWindow removeWindow = new RemoveWindow();
            removeWindow.createRemoveFrame();
        }
        if (src == parent.buttonGetE) {
            model.getAllEmployees();
        }
        if (src == parent.buttonGetActiveE) {
            model.getActiveEmployees();
        }
    }
}
