package attachmentservice;

import javax.xml.ws.Endpoint;

public class Publish {
		public static void main(String[] args) {
			ImageAttachService ias=new ImageAttachServiceImpl();
			Endpoint.publish("http://localhost:5050/ws/attachmentimage", ias);
			
			System.out.println("attachment service ready...");
		}
}
