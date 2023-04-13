package service;

import skypro.dz.Dao.EmployeeDAO;
import skypro.dz.Employee;

public class EmployeeService {
    private static EmployeeDAO employeeDao;

    public EmployeeService() {
        employeeDao = new EmployeeDAO();
    }

    public void addNewEmployee(Employee entity) {
        employeeDao.openCurrentSessionWithTransaction();
        employeeDao.addNewEmployee(entity);
        employeeDao.closeCurrentSessionWithTransaction();
    }

    public void updateById(Employee entity) {
        employeeDao.openCurrentSessionWithTransaction();
        employeeDao.updateById(entity);
        employeeDao.closeCurrentSessionWithTransaction();
    }

    public Employee findById(Long id) {
        employeeDao.openCurrentSession();
        Employee employee = employeeDao.findById(id);
        employeeDao.closeCurrentSession();
        return employee;
    }

    public void deleteById(Long id) {
        employeeDao.openCurrentSessionWithTransaction();
        Employee employee = employeeDao.findById(id);
        employeeDao.deleteById(employee);
        employeeDao.closeCurrentSessionWithTransaction();
    }

    public List<Employee> findAll() {
        employeeDao.openCurrentSession();
        List<Employee> employees = employeeDao.findAll();
        employeeDao.closeCurrentSession();
        return employees;
    }
}
