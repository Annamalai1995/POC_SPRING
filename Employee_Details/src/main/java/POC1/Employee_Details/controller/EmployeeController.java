package POC1.Employee_Details.controller;

import POC1.Employee_Details.dto.EmployeeDto;
import POC1.Employee_Details.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    //Add Employee
    @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }
    //GET EMployee
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")Long employeeId){
       EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
       return  new ResponseEntity<>(employeeDto,HttpStatus.OK);

    }
    //GET ALL EMPLOYESS:
    @GetMapping
    public  ResponseEntity<List<EmployeeDto>> getAllEMployees()
    {
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return  new ResponseEntity<>(employees,HttpStatus.OK);
    }

    //Update Employee
//    @PutMapping("{id}")
//    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {
//        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId,updatedEmployee);
//
//        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
//    }


}
