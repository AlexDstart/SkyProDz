package skypro.dz;



import skypro.dz.Dao.EmloyeeDAO;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();

        task1(employeeService);
        task2(employeeService);
        task3(employeeService);
        task4(employeeService);
        task5(employeeService);

    }

    //Получение конкретного объекта Employee по id
    public static void task1(EmployeeService employeeService) {
        System.out.println("Получение конкретного объекта Employee по id");
        Long id = 3L;
        Employee employee = employeeService.findById(id);
        System.out.println("Employee found with id " + id + " is =>" + employee.toString());
    }

    //Создание (добавление) сущности Employee в таблицу
    public static void task2(EmployeeService employeeService) {
        System.out.println("Создание (добавление) сущности Employee в таблицу");
        Employee employee = new Employee("Peter", "O'Relly", "male", 44, 2L);
        employeeService.addNewEmployee(employee);
    }

    //Изменение конкретного объекта Employee в базе по id
    public static void task3(EmployeeService employeeService) {
        System.out.println("Изменение конкретного объекта Employee в базе по id");
        Long id = 3L;
        Employee updateEmployeeById = employeeService.findById(id);
        updateEmployeeById.setAge(22);
        employeeService.updateById(updateEmployeeById);
    }

    //Удаление конкретного объекта Employee из базы по id
    public static void task4(EmployeeService employeeService) {
        System.out.println("Удаление конкретного объекта Employee из базы по id");
        Long id = 21L;
        employeeService.deleteById(id);
    }

    //Получение списка всех объектов Employee из базы
    public static void task5(EmployeeService employeeService) {
        System.out.println("Получение списка всех объектов Employee из базы");
        List<Employee> employees = employeeService.findAll();
        System.out.println("Employees found are :");
        for (Employee e : employees) {
            System.out.println("-" + e.toString());
        }
    }
}



