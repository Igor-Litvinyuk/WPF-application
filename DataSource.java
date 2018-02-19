import java.util.ArrayList;
import java.util.List;

public class DataSource {

    //Объявляем и инициализируем необходимые поля:
    private List<Employee> employees = new ArrayList<Employee>(){{
        add(new Employee("TestEmployee", "Jon", 35, "01.01.1991", true));
        add(new Employee("TestEmployee", "Vlad", 29, "12.08.1889", false));
        add(new Employee("TestEmployee", "Andrey", 78, "31.10.1993", true));
    }};

    //Singleton
    private static DataSource ourInstance = new DataSource();

    public static DataSource getInstance() {
        return ourInstance;
    }

    //Создаем конструктор:
    private DataSource() {
    }

    //Создаем метод получения списка работников:
    public List<Employee> getEmployees() {
        return employees;
    }
}
