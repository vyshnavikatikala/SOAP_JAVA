package clientpack;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import attachmentservice.ImageAttachService;

public class ImageWriteClient {
	public static void main(String[] args)throws Exception {
		URL url=new URL("http://localhost:5050/ws/attachmentimage?wsdl");
		
		QName qname=new QName("http://attachmentservice/","ImageAttachServiceImplService");
		
		Service service=Service.create(url,qname);
		
		ImageAttachService ias=service.getPort(ImageAttachService.class);
		
		BindingProvider bp=(BindingProvider)ias;
		SOAPBinding soapbinding=(SOAPBinding)bp.getBinding();
		soapbinding.setMTOMEnabled(true);
		
		Image img=ImageIO.read(new File("rcbook.jpeg"));
		
		ias.setImage(img, "rcbookcopy.jpeg");
	}
}
