import javax.swing.*;
import java.awt.*;

public class MainWindow {

    //Объявляем необходимые поля:
    private JPanel panel;
    private JFrame frame;
    private Controller controller;

    //Объявляем и нициализируем кнопки:
    JButton buttonAddE = new JButton("Add employee");
    JButton buttonRemoveE = new JButton("Remove employee");
    JButton buttonGetE = new JButton("Get all employees");
    JButton buttonGetActiveE = new JButton("Get active employees");

    //Создаем конструктор:
    private MainWindow() {
        initPanel();
        initFrame();
    }

    //Инициализируем панель:
    private void initPanel() {
        panel = new JPanel();
        GridLayout g1 = new GridLayout(2, 2);
        panel.setLayout(g1);

        Font font1 = new Font("Arial", Font.PLAIN, 20);

        buttonAddE.setFont(font1);
        buttonAddE.setForeground(Color.BLUE);
        panel.add(buttonAddE);
        buttonRemoveE.setFont(font1);
        buttonRemoveE.setForeground(Color.RED);
        panel.add(buttonRemoveE);
        buttonGetE.setFont(font1);
        panel.add(buttonGetE);
        buttonGetActiveE.setFont(font1);
        panel.add(buttonGetActiveE);

        //Обрабатываем нажатия мыши на кнопки
        controller = new Controller(this);
        buttonAddE.addActionListener(controller);
        buttonRemoveE.addActionListener(controller);
        buttonGetE.addActionListener(controller);
        buttonGetActiveE.addActionListener(controller);
    }

    //Инициализируем окно:
    private void initFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Simple WPF-application");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(getImage());
    }

    //Создаем иконку нашего приложения:
    private Image getImage() {
        ImageIcon icon = new ImageIcon("icon.png");
        return icon.getImage();
    }

    //Основной метод:
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}
