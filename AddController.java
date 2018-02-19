import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController implements ActionListener{

    //Объявляем и инициализируем необходимые поля:
    private AddWindow addParent;
    private Model model = new Model();

    //Создаем конструктор:
    AddController(AddWindow addParent) {
        this.addParent = addParent;
    }

    //Обрабатываем нажатия мышкой на кнопки
    /**
     * При нажатии на кнопку Save в список будет добавляться новый работник
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addParent.buttonSave) {
            if (addParent.getFirstNameField() != null && addParent.getLastNameField() != null &&
                    addParent.getIdField() != 0 && addParent.getBirthDayField() != null) {
                if(!model.checkId(addParent)){
                    model.createNewEmployee(addParent);
                    addParent.addFrame.dispose();
                }
            }
        }
    }
}
