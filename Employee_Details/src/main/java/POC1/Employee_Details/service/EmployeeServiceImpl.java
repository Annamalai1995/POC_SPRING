package POC1.Employee_Details.service;

import POC1.Employee_Details.dto.EmployeeDto;
import POC1.Employee_Details.entity.Employee;
import POC1.Employee_Details.exception.ResourceNotFoundException;
import POC1.Employee_Details.mapper.EmployeeMapper;
import POC1.Employee_Details.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapTEmployee(employeeDto);
        Employee createEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("employee is not exists with given:"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

    }

//    @Override
//    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
//        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()
//                ->new ResourceNotFoundException("Employee is not exists given id:"+employeeId));
//      employee.setFirstName(updateEmployee.getFirstName());
//      employee.setLastName(updateEmployee.getLastName());
//      employee.setEmail(updateEmployee.getEmail());
//      Employee updatedEmployee=employeeRepository.save(employee);
//      return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
//
//
//    }
}
