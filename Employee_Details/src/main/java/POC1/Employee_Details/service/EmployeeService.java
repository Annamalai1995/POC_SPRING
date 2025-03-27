package POC1.Employee_Details.service;

import POC1.Employee_Details.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
     //EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee);


}
