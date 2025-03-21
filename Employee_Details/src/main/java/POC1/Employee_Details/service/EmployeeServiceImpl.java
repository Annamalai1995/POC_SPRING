package POC1.Employee_Details.service;

import POC1.Employee_Details.dto.EmployeeDto;
import POC1.Employee_Details.entity.Employee;
import POC1.Employee_Details.mapper.EmployeeMapper;
import POC1.Employee_Details.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
