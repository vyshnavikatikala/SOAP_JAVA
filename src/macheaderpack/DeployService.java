package macheaderpack;

import javax.xml.ws.Endpoint;

public class DeployService {
	public static void main(String[] args) {
		SecureService ss=new SecureServiceImpl();
		
		Endpoint.publish("http://localhost:3030/ws/ss", ss);
		
		System.out.println("Service Ready and available at this URL - http://localhost:3030/ws/hello?wsdl");
	}
}
