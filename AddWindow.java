import javax.swing.*;
import java.awt.*;

public class AddWindow {

    //Объявляем и инициализируем необходимые поля:
    private JPanel addWindow;
    JFrame addFrame;
    private JTextField firstNameField, lastNameField, birthDayField, idField, isActiveField;
    private JLabel firstNameLabel, lastNameLabel, birthDayLabel, idLabel, isActiveLabel, example;
    JButton buttonSave = new JButton("Save");
    private AddController addController;

    //Создаем конструктор:
    AddWindow() {
    }

    //Метод по созданию окна при нажатии на кнопку AddEmployee:
    public void createAddFrame() {
        initAddPanel();
        initAddFrame();
    }

    //Добавляем все необходимое на панель:
    private void initAddPanel() {
        addWindow = new JPanel();
        FlowLayout f1 = new FlowLayout();
        addWindow.setLayout(f1);
        firstNameLabel = new JLabel("Enter name:");
        addWindow.add(firstNameLabel);
        firstNameField = new JTextField(40);
        addWindow.add(firstNameField);
        lastNameLabel = new JLabel("Enter surname:");
        addWindow.add(lastNameLabel);
        lastNameField = new JTextField(40);
        addWindow.add(lastNameField);
        idLabel = new JLabel("Enter id:");
        addWindow.add(idLabel);
        idField = new JTextField(40);
        addWindow.add(idField);
        birthDayLabel = new JLabel("Enter date of birth:");
        addWindow.add(birthDayLabel);
        birthDayField = new JTextField(40);
        addWindow.add(birthDayField);
        isActiveLabel = new JLabel("Active, yes?:");
        addWindow.add(isActiveLabel);
        isActiveField = new JTextField(40);
        addWindow.add(isActiveField);
        example = new JLabel("------------------------------  Date of birth example: 01.11.1993  ------------------------------");
        addWindow.add(example);
        Font font = new Font("Arial", Font.PLAIN, 25);
        buttonSave.setFont(font);
        addWindow.add(buttonSave);

        addController = new AddController(this);
        buttonSave.addActionListener(addController);
    }

    //Инициализируем окно:
    private void initAddFrame() {
        addFrame = new JFrame();
        addFrame.setSize(500,350);
        addFrame.setContentPane(addWindow);
        addFrame.setTitle("Add employee");
        addFrame.setResizable(false);
        addFrame.setVisible(true);
        addFrame.setLocationRelativeTo(null);
    }

    //Создаем методы для получения текста из полей окна:
    public String getFirstNameField() {
        String result = null;
        if (!firstNameField.getText().isEmpty()){
            result = firstNameField.getText();
        }
        else {
            System.out.println("Enter name!");
        }
        return result;
    }

    public String getLastNameField() {
        String result = null;
        if (!lastNameField.getText().isEmpty()){
            result = lastNameField.getText();
        }
        else {
            System.out.println("Enter surname!");
        }
        return result;
    }

    //Создадим сложный метод получения даты рождения.
    //Этот метод также включает в себя проверку на:
    //- пустое поле;
    //- соответствие шаблону dd.mm.yyyy;
    //- соответствие количеству календарных дней того или иного месяца.
    public String getBirthDayField() {
        String result = null;
        String text = birthDayField.getText();
        if (text.isEmpty()){
            System.out.println("Enter date of birth!");
        }
        else if (text.matches("\\d\\d.\\d\\d.\\d\\d\\d\\d")){
            int day = Integer.parseInt(text.substring(0,2));
            int month = Integer.parseInt(text.substring(3,5));
            int year = Integer.parseInt(text.substring(6));
            //Шанс родиться в високосный год 29-го февраля становит всего 0,068%, но стоит сделать проверку:
            int daysOfLeapYear;
            if (year%4 == 0 && year%100 !=0 || year%400 == 0){
                daysOfLeapYear = 29;
            }
            else {
                daysOfLeapYear = 28;
            }
            if (month >= 1 && month <=12){
                if (year >=1918 && year <= 2000){ //Человек младше 18 лет не может быть добавлен в список работников
                    if (month == 1 && day > 0 && day <= 31 ||
                        month == 2 && day > 0 && day <= daysOfLeapYear ||
                        month == 3 && day > 0 && day <= 31 ||
                        month == 4 && day > 0 && day <= 30 ||
                        month == 5 && day > 0 && day <= 31 ||
                        month == 6 && day > 0 && day <= 30 ||
                        month == 7 && day > 0 && day <= 31 ||
                        month == 8 && day > 0 && day <= 31 ||
                        month == 9 && day > 0 && day <= 30 ||
                        month == 10 && day > 0 && day <= 31 ||
                        month == 11 && day > 0 && day <= 30 ||
                        month == 12 && day > 0 && day <= 31){
                        result = birthDayField.getText();

                    }
                    else {
                        System.out.println("Incorrect day!");
                    }
                }
                else {
                    System.out.println("Incorrect year!");
                }
            }
            else System.out.println("Incorrect month!");
        }
        else {
            System.out.println("Enter correct date of birth!");
        }
        return result;
    }

    public int getIdField() {
        int result = 0;
        if (idField.getText().isEmpty() || idField.getText().matches("\\D+")) {
            System.out.println("Enter correct id!");
        }
        else {
            result = Integer.parseInt(idField.getText());
        }
        return result;
    }

    //Работник по умолчанию не активен(false) при любых введенных данных в поле, кроме yes в поле Active, yes?
    public boolean getIsActiveField() {
        boolean isAct;
        isAct = isActiveField.getText().equals("yes");
        return isAct;
    }
}
