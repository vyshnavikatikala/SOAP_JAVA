package macheaderpack;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@HandlerChain(file="handler-chain.xml")
@WebService(endpointInterface = "macheaderpack.SecureService")
public class SecureServiceImpl implements SecureService{
	
	@Resource
	WebServiceContext ctx;
	
@WebMethod
@Override
public String sayHello(String name) {
	// TODO Auto-generated method stub
	//MessageContext context=ctx.getMessageContext();
	/*
	 * try{
	 * 
	 * SOAPMessageContext context=(SOAPMessageContext)ctx.getMessageContext();
	 * SOAPMessage soapMsg = context.getMessage(); SOAPEnvelope soapEnv =
	 * soapMsg.getSOAPPart().getEnvelope(); SOAPHeader soapHeader =
	 * soapEnv.getHeader(); if (soapHeader == null){ soapHeader =
	 * soapEnv.addHeader(); } String mac = GetMacAddress.getAddress(); QName qname =
	 * new QName("http://macheaderpack/", "macAddress"); SOAPHeaderElement
	 * soapHeaderElement = soapHeader.addHeaderElement(qname);
	 * soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
	 * soapHeaderElement.addTextNode(mac); soapMsg.saveChanges();
	 * soapMsg.writeTo(System.out); }catch(Exception e) { e.printStackTrace(); }
	 */
	return "welcome to webservices...:"+name;
}
}
