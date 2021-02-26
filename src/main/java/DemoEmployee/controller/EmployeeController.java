package DemoEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DemoEmployee.exception.service.EmployeeServiceException;
import DemoEmployee.model.Employee;
import DemoEmployee.service.serviceImpl.ServiceImpl;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	static String msg = "";

	@Autowired
	public ServiceImpl service;

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(service.addEmployee(employee), HttpStatus.CREATED);
		} catch (EmployeeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
		} catch (EmployeeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/all")
	public ResponseEntity<?> getEmployeeDetails() {
		try {
			return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
		} catch (EmployeeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(service.deleteEmployeeById(id), HttpStatus.NO_CONTENT);

		} catch (EmployeeServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

}
