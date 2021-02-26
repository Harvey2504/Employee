package DemoEmployee.exception;

public class EmployeeCustomException extends Exception {

	public EmployeeCustomException() {
		super();
	}

	public EmployeeCustomException(Throwable arg0) {
		super(arg0);
	}

	public EmployeeCustomException(String arg0) {
		super(arg0);
	}

	public EmployeeCustomException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
