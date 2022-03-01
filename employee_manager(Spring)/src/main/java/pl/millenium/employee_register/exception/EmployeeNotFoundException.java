package pl.millenium.employee_register.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
