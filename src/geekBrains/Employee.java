package geekBrains;

import javafx.geometry.Pos;

/*1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
2. Конструктор класса должен заполнять эти поля при создании объекта;*/
public class Employee {
    String Name;
    String Surname;
    String Position;
    String email;
    int phoneNumber;
    int salary;
    int age;

    public Employee (String _name, String _surname, String _position, String _email, int _phoneNumber, int _salary, int _age) {
        Name = _name;
        Surname = _surname;
        Position = _position;
        email = _email;
        phoneNumber = _phoneNumber;
        salary = _salary;
        age = _age;

    }

    public void printInConsole () {
        System.out.println("Имя: " + Name);
        System.out.println("Фамилия: " + Surname);
        System.out.println("Должность: " + Position);
        System.out.println("Почта: " + email);
        System.out.println("ЗП: " + salary);
        System.out.println("Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}
