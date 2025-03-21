package POC1.Employee_Details.mapper;

import POC1.Employee_Details.dto.EmployeeDto;
import POC1.Employee_Details.entity.Employee;

public class EmployeeMapper {
    public  static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
    }
    public static  Employee mapTEmployee(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
