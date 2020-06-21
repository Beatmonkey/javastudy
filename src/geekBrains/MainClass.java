package geekBrains;

public class MainClass {
    public static void main(String[] args) {
//        geekBrains.Employee employee1 = new geekBrains.Employee();
//        System.out.println(employee1);

//        employee1.printInConsole();

        Employee[] employeeArray = new Employee[6];
        employeeArray[0] = new Employee("Дима", "Иванов", "Сантехник", "test1@test.com", 334, 30000, 25);
        employeeArray[1] = new Employee("Олег", "Петров", "Программист", "test2@test.com", 335, 130000, 25);
        employeeArray[2] = new Employee("Андрей", "Сидоров", "Электрик", "test3@test.com", 336, 60000, 34);
        employeeArray[3] = new Employee("Саша", "Попов", "Бухгалтер", "test4@test.com", 337, 80000, 35);
        employeeArray[4] = new Employee("Мария", "Титова", "Директор", "test5@test.com", 337, 180000, 42);
        employeeArray[5] = new Employee("Виктория", "Смирнова", "Кассир", "test6@test.com", 337, 70000, 27);


        for (int i = 0; i < employeeArray.length; i++) {
                if (employeeArray[i].getAge() > 40) {
                    employeeArray[i].printInConsole();
            }

        }

   }
}

