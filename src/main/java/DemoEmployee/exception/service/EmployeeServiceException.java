package DemoEmployee.exception.service;

public class EmployeeServiceException extends Exception {
	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(Throwable arg0) {
		super(arg0);
	}

	public EmployeeServiceException(String arg0) {
		super(arg0);
	}

	public EmployeeServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
