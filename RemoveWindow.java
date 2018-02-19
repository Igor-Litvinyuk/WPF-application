import javax.swing.*;
import java.awt.*;

public class RemoveWindow {

    //Объявляем и инициализируем необходимые поля:
    private JPanel removeWindow;
    JFrame removeFrame;
    private JTextField enterIdField;
    private JLabel enterIdLabel;
    JButton buttonRemove = new JButton("Remove");
    private RemoveController removeController;

    //Создаем конструктор:
    RemoveWindow() {
    }

    //Метод по созданию окна при нажатии на кнопку RemoveEmployee:
    public void createRemoveFrame() {
        initRemovePanel();
        initRemoveFrame();
    }

    //Добавляем все необходимое на панель:
    private void initRemovePanel() {
        removeWindow = new JPanel();
        FlowLayout f2 = new FlowLayout();
        removeWindow.setLayout(f2);
        enterIdLabel = new JLabel("Enter id of employee:");
        removeWindow.add(enterIdLabel);
        enterIdField = new JTextField(40);
        removeWindow.add(enterIdField);
        Font font = new Font("Arial", Font.PLAIN, 25);
        buttonRemove.setFont(font);
        removeWindow.add(buttonRemove);

        removeController = new RemoveController(this);
        buttonRemove.addActionListener(removeController);
    }

    //Инициализируем окно:
    private void initRemoveFrame() {
        removeFrame = new JFrame();
        removeFrame.setSize(500,150);
        removeFrame.setContentPane(removeWindow);
        removeFrame.setTitle("Remove employee");
        removeFrame.setResizable(false);
        removeFrame.setVisible(true);
        removeFrame.setLocationRelativeTo(null);
    }

    public int getIdForRemove(){
        int result = 0;
        if (enterIdField.getText().isEmpty() || enterIdField.getText().matches("\\D+")) {
            System.out.println("Enter correct id!");
        }
        else {
            result = Integer.parseInt(enterIdField.getText());
        }
        return result;
    }

}
