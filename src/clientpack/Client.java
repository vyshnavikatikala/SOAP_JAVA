package clientpack;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import objservice.ObjectServiceInterface;

public class Client {
	public static void main(String[] args)throws Exception {
		URL url=new URL("http://localhost:4040/ws/objservice?wsdl");
		
		QName qname=new QName("http://www.shoiabcodaservice.com","ObjectServiceService");
		
		Service service=Service.create(url,qname);
		
		ObjectServiceInterface osi=service.getPort(ObjectServiceInterface.class);
		
		String result=osi.sayHello("coda services..");
		
		System.out.println("Result...."+result);
	}
	
}
