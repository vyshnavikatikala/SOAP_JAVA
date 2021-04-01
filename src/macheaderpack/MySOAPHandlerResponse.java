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

public class MySOAPHandlerResponse implements SOAPHandler<SOAPMessageContext>{
public MySOAPHandlerResponse() {
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
		addHeader(context);
		Boolean isResponse=(Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		if(isResponse) {
			System.out.println("response message.....");
			try{
				 SOAPMessage soapMsg = context.getMessage();
		         SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
		         SOAPHeader soapHeader = soapEnv.getHeader();
		         soapMsg.writeTo(System.out);
				if (soapHeader == null){
					soapHeader = soapEnv.addHeader();
					generateSOAPErrMessage(soapMsg, "No	SOAP header.");
				}
				
				Iterator it =soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				if (it == null || !it.hasNext()){
					generateSOAPErrMessage(soapMsg, "No	header block for next actor.");
				}
				
				Node macNode = (Node) it.next();
				String macValue = (macNode == null) ?null : macNode.getValue();
				System.out.println("The mac address is...:"+macValue);
				if (macValue == null){
					generateSOAPErrMessage(soapMsg, "No	mac address in header block.");
				}
				//business logic
				if(!macValue.equals("28-C6-3F-BB-DA-1E")){
					generateSOAPErrMessage(soapMsg,	"Invalid mac address, access is denied.");
				}
				
				soapMsg.writeTo(System.out);
				
			}catch(Exception e) {		e.printStackTrace();		}
		}
				
		return true;
	}

	public void addHeader(SOAPMessageContext context) {
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
	@Override
	public Set<QName> getHeaders() {
		System.out.println("get headers method of the soaphandler called...");
		return null;
	}

}
