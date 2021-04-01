package attachmentservice;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ImageAttachService {
	@WebMethod
	public void setImage(Image image,String name);
	@WebMethod
	public Image getImage(String name);
}
