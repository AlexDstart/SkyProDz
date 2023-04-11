package skypro.dz.Dao;



import skypro.dz.Employee;

import java.util.List;

public interface EmloyeeDAO {

    List<Employee> getAllEmployees();
    List<Employee> getEmployeeById();
    void addEmployee();
    void updateEmployee();
    void deleteEmployee();

}
