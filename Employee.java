public class Employee {

    //Объявляем необходимые поля:
    private String firstName;
    private String lastName;
    private int id;
    private String birthDay;
    private boolean isActive;

    Employee(String firstName, String lastName, int id, String birthDay, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthDay = birthDay;
        this.isActive = isActive;
    }

    //Создаем сеттеры и геттеры полей:
    //Метод getName() объединяет first name и last name, чтобы можно было корректно отсортировать список по алфавиту
    public String getName() {
        return firstName + " " + lastName;
    }

    public long getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    //Переопределяем метод toString:
    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName + ". Date of birth: " + birthDay + ". isActive = " + isActive + ".";
    }
}
