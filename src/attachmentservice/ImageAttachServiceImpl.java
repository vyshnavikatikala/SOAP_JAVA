package attachmentservice;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@HandlerChain(file = "handler-chain.xml")
@MTOM
@WebService(endpointInterface = "attachmentservice.ImageAttachService")
public class ImageAttachServiceImpl implements ImageAttachService{

	@WebMethod
	@Override
	public void setImage(Image image, String name) {
		try {
		File imagefile=new File(name);
		BufferedImage bimage=(BufferedImage)image;
		ImageIO.write(bimage,"jpeg",imagefile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@WebMethod
	@Override
	public Image getImage(String name) {
		try {
		File imagefile=new File(name);
		return ImageIO.read(imagefile);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
