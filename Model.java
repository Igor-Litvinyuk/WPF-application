import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Model {

    //Объявляем и инициализируем необходимые поля:
    private DataSource dataSource = DataSource.getInstance();
    private List<Employee> list = dataSource.getEmployees();

    //Создаем метод по добавлению работников в список:
    public void createNewEmployee(AddWindow addParent) {
        list.add(new Employee(addParent.getFirstNameField(), addParent.getLastNameField(),
                addParent.getIdField(), addParent.getBirthDayField(), addParent.getIsActiveField()));
    }

    //Создаем метод для получения списка всех работников:
    public void getAllEmployees() {
        System.out.println("List of all employees (sorted by name and surname):");
        System.out.println("------------------------------------------------------------");
        if (!list.isEmpty()) {
            list.sort(Comparator.comparing(Employee::getName));
        }
        for (Employee employees : list) {
            System.out.println(employees);
        }
        System.out.println("============================================================");
    }

    //Создаем метод для получения списка всех активных работников:
    public void getActiveEmployees() {
        System.out.println("List of active employees (sorted by name and surname):");
        System.out.println("------------------------------------------------------------");
        List<Employee> activeList = new ArrayList<>();
        for (Employee aList : list) {
            if (aList.isActive()) {
                activeList.add(aList);
            }
        }

        if (!activeList.isEmpty()) {
            activeList.sort(Comparator.comparing(Employee::getName));
        }
        for (Employee employees : activeList) {
            System.out.println(employees);
        }
        System.out.println("============================================================");
    }

    //Создаем метод для удаления работника из списка:
    public void removeEmployee(RemoveWindow removeParent) {
        int id = removeParent.getIdForRemove();
        int index;
        boolean noId = false;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                index = i;
                list.remove(index);
                System.out.println("Employee with id = " + id + " was deleted!");
                noId = false;
                break;
            }
            else{
                noId = true;
            }
        }
        if (noId){
            System.out.println("No employee with that id!");
        }
    }

    //id не должен повторятся
    //Создаем метод, который проверяет существует ли в списке работник с id, который ввели в поле:
    public boolean checkId(AddWindow addParent) {
        int id = addParent.getIdField();
        boolean result = false;
        for (Employee aList : list) {
            if (id == aList.getId()) {
                System.out.println("An employee with that id already exists!");
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }
}
