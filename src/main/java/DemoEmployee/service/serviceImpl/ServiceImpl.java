package DemoEmployee.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoEmployee.exception.service.EmployeeServiceException;
import DemoEmployee.model.Employee;
import DemoEmployee.repository.EmployeeRepository;
import DemoEmployee.service.EmployeeService;

@Service
public class ServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeServiceException {
		// TODO Auto-generated method stub
		try {
			Employee newEmployee = employeeRepository.save(employee);
			return newEmployee;
		} catch (Exception e) {
			throw new EmployeeServiceException(e);
		}

	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeServiceException {
		// TODO Auto-generated method stub
		try {
			Employee temp = employeeRepository.findById(id).get();
			return temp;
		} catch (Exception e) {
			throw new EmployeeServiceException(e);
		}

	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeServiceException {
		// TODO Auto-generated method stub
		List<Employee> employee = new ArrayList<Employee>();
		employee = employeeRepository.findAll();
		return employee;
	}

	@Override
	public Employee deleteEmployeeById(int id) throws EmployeeServiceException {
		// TODO Auto-generated method stub

		try {
			Employee temp = employeeRepository.findById(id).get();
			employeeRepository.deleteById(id);
			return temp;
		} catch (Exception e) {
			throw new EmployeeServiceException(e);
		}
	}

}
