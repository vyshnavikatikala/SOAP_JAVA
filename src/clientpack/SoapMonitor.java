package clientpack;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SoapMonitor implements SOAPHandler<SOAPMessageContext>{

	@Override
	public void close(MessageContext arg0) {
		System.out.println("close method called....");
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		try {
			System.out.println("handle fault is called....");
			SOAPMessage soapmsg=context.getMessage();
			soapmsg.writeTo(new PrintStream(System.out));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			Boolean response=(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			System.out.println("handle message is called....");
			
			FileOutputStream fos=new FileOutputStream("outreq.xml");
			FileOutputStream fosres=new FileOutputStream("outres.xml");
			if(!response) {
				SOAPMessage soapmsg=context.getMessage();
				soapmsg.writeTo(fos);
				System.out.println("Request Message....");
				soapmsg.writeTo(new PrintStream(System.out));
			}
			else {
				SOAPMessage soapmsg=context.getMessage();
				soapmsg.writeTo(fosres);
				System.out.println("Response Message....");
				soapmsg.writeTo(new PrintStream(System.out));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("get headers called....");
		return null;
	}
	
}
