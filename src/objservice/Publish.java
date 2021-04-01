package objservice;

import javax.xml.ws.Endpoint;

public class Publish {
	public static void main(String[] args) {
		ObjectServiceInterface osi=new ObjectService();
		
		Endpoint.publish("http://localhost:4040/ws/objservice", osi);
		System.out.println("Object service published...");
	}
}
