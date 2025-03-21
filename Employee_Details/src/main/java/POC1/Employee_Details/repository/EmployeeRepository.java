package POC1.Employee_Details.repository;

import POC1.Employee_Details.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
