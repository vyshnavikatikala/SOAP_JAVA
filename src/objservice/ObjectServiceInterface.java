package objservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "objservice", targetNamespace = "http://www.shoiabcodaservice.com")
public interface ObjectServiceInterface {
	@WebMethod
	public String sayHello(String name);
	@WebMethod
	public Employee getEmployee();
	@WebMethod
	public List<Employee> getEmployees();
	@WebMethod
	public void setEmployee(Employee emp);
	@WebMethod
	public void setEmployees(List<Employee> emplist);
}
