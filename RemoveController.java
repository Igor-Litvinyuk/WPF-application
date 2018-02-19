import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveController implements ActionListener {

    //Объявляем и инициализируем необходимые поля:
    private RemoveWindow removeParent;
    private Model model = new Model();

    //Создаем конструктор:
    RemoveController(RemoveWindow removeParent) {
        this.removeParent = removeParent;
    }

    //Обрабатываем нажатия мышкой на кнопки
    /**
     * При нажатии на кнопку Remove из списка будет удаляться работник с указанным номером id.
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == removeParent.buttonRemove){
            if (removeParent.getIdForRemove() != 0) {
                model.removeEmployee(removeParent);
                removeParent.removeFrame.dispose();
            }
        }
    }
}
