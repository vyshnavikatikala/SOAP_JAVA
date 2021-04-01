package macheaderpack;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SecureService {
	@WebMethod
	public String sayHello(String name);
}
