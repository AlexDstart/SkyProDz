package skypro.dz;





import model.City;
import model.Employee;
import service.CityService;
import service.EmployeeService;

import java.util.List;


public class Application {

    public static void main(String[] args) {

        CityService cityService = new CityService();
        EmployeeService employeeService = new EmployeeService();

        City city = new City("Lisbon");

        addNewCity(cityService, city);

        Employee employee1 = new Employee("Tosh", "Simpson", "male", 33, 7L);
        Employee employee2 = new Employee("Anna", "Bawl", "male", 50, 4L);
        Employee employee3 = new Employee("Betty", "Trump", "female", 19, 3L);

        addNewEmployee(employeeService, employee1);
        addNewEmployee(employeeService, employee2);
        addNewEmployee(employeeService, employee3);

        updateEmployeeById(employeeService, 31L);

        deleteCityById(cityService, 7L);

        findAllCities(cityService);
        findAllEmployees(employeeService);

    }


    public static void findAllCities(CityService cityService) {
        System.out.println("Получение списка всех объектов City из базы");
        List<City> cities = cityService.findAll();
        System.out.println("Cities found are :");
        for (City c : cities) {
            System.out.println("-" + c.toString());
        }
    }


    public static void addNewCity(CityService cityService, City city) {
        System.out.println("Создание (добавление) сущности City в таблицу");
        cityService.addNewEmployee(city);
    }


    public static void addNewEmployee(EmployeeService employeeService, Employee employee) {
        System.out.println("Создание  сущности Employee в таблицу");
        employeeService.addNewEmployee(employee);
    }


    public static void updateEmployeeById(EmployeeService employeeService, Long id) {
        System.out.println("Изменение конкретного объекта Employee в базе по id");
        Employee updateEmployeeById = employeeService.findById(id);
        updateEmployeeById.setCityId(6L);
        employeeService.updateById(updateEmployeeById);
    }


    public static void deleteCityById(CityService cityService, Long id) {
        System.out.println("Удаление конкретного объекта City из базы по id");
        cityService.deleteById(id);
    }

    //Получение списка всех объектов Employee из базы
    public static void findAllEmployees(EmployeeService employeeService) {
        System.out.println("Получение списка всех объектов Employee из базы");
        List<Employee> employees = employeeService.findAll();
        System.out.println("Employees found are :");
        for (Employee e : employees) {
            System.out.println("-" + e.toString());
        }
    }
}



