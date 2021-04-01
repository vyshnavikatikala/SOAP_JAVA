package objservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@HandlerChain(file = "handler-chain.xml")
@WebService(endpointInterface = "objservice.ObjectServiceInterface", targetNamespace = "http://www.shoiabcodaservice.com")
public class ObjectService implements ObjectServiceInterface{
	@WebMethod
	public String sayHello(String name) {
		return "Welcome to Webservices...:"+name;
	}
	@WebMethod
	public Employee getEmployee() {
		System.out.println("get employee called....");
		Employee emp=new Employee();
		emp.setEname("ramu");
		emp.setDept("development");
		emp.setEsal(5000);
		return emp;
	}
	
	@WebMethod
	public List<Employee> getEmployees(){
		return new GetAllEmployees().getAllEmployees();
	}
	@WebMethod
	public void setEmployee(Employee emp) {
		System.out.println(emp);
	}
	
	@WebMethod
	public void setEmployees(List<Employee> e) {
		for(Employee emp:e) {
			System.out.println(emp);
		}
	}
	
}





