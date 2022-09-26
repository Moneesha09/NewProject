package ServiceInterface;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.Employee;

public interface EmployeeInterface {
	public List<Employee> getAllEmployee();
	public Employee createInst(Employee i);
	public ResponseEntity<Employee> getEmployeeById( int id);
	public ResponseEntity<Map<String, Boolean>> deleteEmployee( int id);

}
