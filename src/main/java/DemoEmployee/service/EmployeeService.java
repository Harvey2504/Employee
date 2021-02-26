package DemoEmployee.service;

import java.util.List;

import DemoEmployee.exception.service.EmployeeServiceException;
import DemoEmployee.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee) throws EmployeeServiceException;

	Employee getEmployeeById(int id) throws EmployeeServiceException;

	List<Employee> getAllEmployees() throws EmployeeServiceException;

	Employee deleteEmployeeById(int id) throws EmployeeServiceException;

}
