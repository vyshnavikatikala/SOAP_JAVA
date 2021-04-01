package objservice;

import java.util.ArrayList;
import java.util.List;

public class GetAllEmployees{
	
	List<Employee> emplist=new ArrayList<Employee>();
	
	public List<Employee> getAllEmployees(){
		Employee emp=new Employee();
		emp.setEname("ramu");
		emp.setDept("development");
		emp.setEsal(5000);
		emplist.add(emp);
		
		Employee emp2=new Employee();
		emp2.setEname("ramu");
		emp2.setDept("development");
		emp2.setEsal(5000);
		emplist.add(emp2);
		
		return emplist;
	}
}