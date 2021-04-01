package macheaderpack;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class MySOAPHandlerRequest implements SOAPHandler<SOAPMessageContext>{
public MySOAPHandlerRequest() {
	System.out.println("soap handler object created...");
}
	@Override
	public void close(MessageContext arg0) {
		System.out.println("close method of soaphandler called...");
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		System.out.println("fault method of soap handler called...");
		return true;
	}
	private void generateSOAPErrMessage(SOAPMessage	msg, String reason) {
		try {
				SOAPBody soapBody =	msg.getSOAPPart().getEnvelope().getBody();
				SOAPFault soapFault = soapBody.addFault();
				soapFault.setFaultString("This is custom...:"+reason);
				throw new SOAPFaultException(soapFault);
			}
			catch(SOAPException e) { e.printStackTrace();}
	}
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("handle message method called.....");
		Boolean isResponse=(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		if(!isResponse) {
			System.out.println("Request Message....");
		try{
			 SOAPMessage soapMsg = context.getMessage();
	         SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
	         SOAPHeader soapHeader = soapEnv.getHeader();
			            if (soapHeader == null){
			            	soapHeader = soapEnv.addHeader();
			            }
			            String mac = GetMacAddress.getAddress();
			            QName qname = new QName("http://macheaderpack/", "macAddress");
			            SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
			            soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
			            soapHeaderElement.addTextNode(mac);
			            soapMsg.saveChanges();			       
			            soapMsg.writeTo(System.out);
				   }catch(Exception e) {
					   e.printStackTrace();
				  }
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("get headers method of the soaphandler called...");
		return null;
	}

}
