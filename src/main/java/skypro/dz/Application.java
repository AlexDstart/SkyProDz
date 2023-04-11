package skypro.dz;



import skypro.dz.Dao.EmloyeeDAO;
import skypro.dz.Dao.EmployeeDAOImpl;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args)  {



    }


    public static void task1() {
        final String user = "postgres";
        final String password = "08051992";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        int id = 3;


        try (Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT id, firstname, lastname, gender, age, city_name " +
                             "FROM employee " +
                             "LEFT JOIN city ON employee.city_id = city.city_id " +
                             "WHERE id = ?")) {
            System.out.println("Соединение установлено!");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String city = resultSet.getString("city_name");

                System.out.print(" id: " + idOfEmployee);
                System.out.print(" Имя: " + firstName);
                System.out.print(" Фамилия: " + lastName);
                System.out.print(" Пол: " + gender);
                System.out.print(" Возраст: " + age);
                System.out.print(" Город: " + city);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }


    public static void task2Part1() {
        EmloyeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.addEmployee();
    }


    public static void task2Part2() {
        EmloyeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.getEmployeeById();
        System.out.println(employees);
    }


    public static void task2Part3() {
        EmloyeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.getAllEmployees();
        System.out.println(employees);
    }


    public static void task2Part4() {
        EmloyeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.updateEmployee();
    }


    public static void task2Part5() {
        EmloyeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.deleteEmployee();
    }
}



