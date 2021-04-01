package macheaderpack;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class SecureClient {
public static void main(String[] args)throws Exception {
	URL url=new URL("http://localhost:3030/ws/ss?wsdl");
	QName qname=new QName("http://macheaderpack/", "SecureServiceImplService");
	Service service=Service.create(url,qname);
	
	SecureService ss=service.getPort(SecureService.class);
	
	String result=ss.sayHello("ramu");
	System.out.println("Result...:"+result);	
}
}
