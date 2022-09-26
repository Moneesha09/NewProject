package ServiceInterface;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;


import com.example.demo.model.Employee;
import com.example.demo.model.Instances;
import com.example.demo.model.Teams;

public interface TeamsInterface {
	public List<Teams> getAllInstances();
	public ResponseEntity<Teams> getEmployeeById(int iid);
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(int iid);
	public Teams createInst(   Teams i);
	public List<Instances> getInstanceByDep(int id);
	public List<Employee> getEmployeeByDep(int id);
}
