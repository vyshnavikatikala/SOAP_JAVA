package clientpack;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import attachmentservice.ImageAttachService;
import objservice.ObjectServiceInterface;

public class ImageReadClient {
	public static void main(String[] args) throws Exception{
		URL url=new URL("http://localhost:5050/ws/attachmentimage?wsdl");
		
		QName qname=new QName("http://attachmentservice/","ImageAttachServiceImplService");
		
		Service service=Service.create(url,qname);
		
		ImageAttachService ias=service.getPort(ImageAttachService.class);
		BindingProvider bp=(BindingProvider)ias;
		SOAPBinding soapbinding=(SOAPBinding)bp.getBinding();
		soapbinding.setMTOMEnabled(true);
		Image img=ias.getImage("rcbook.jpeg");
		
		JFrame jframe=new JFrame();
		jframe.setSize(300,300);
		JLabel jlabel=new JLabel(new ImageIcon(img));
		
		jframe.add(jlabel);
		jframe.setVisible(true);
	}
}
