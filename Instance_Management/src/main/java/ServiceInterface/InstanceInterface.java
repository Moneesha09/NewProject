package ServiceInterface;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;



import com.example.demo.model.History;
import com.example.demo.model.Instances;

public interface InstanceInterface {
	public List<Instances> getAllInstances();
	public Instances createInst( Instances i);
	public ResponseEntity<Instances> getInstanceById( int iid);
	public ResponseEntity<Map<String, Boolean>> deleteInstance( int iid);
	 public ResponseEntity<Instances> updateEmployee( int iid,  Instances ins);
	 public List<History> getHistoryByIns(int id);
	 public Instances saveOrUpdateAlien(Instances alien);

}
