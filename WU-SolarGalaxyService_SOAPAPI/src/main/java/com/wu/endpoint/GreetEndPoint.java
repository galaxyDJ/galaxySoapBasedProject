package com.wu.endpoint;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wu.service.play.GreetService;

@Endpoint
public class GreetEndPoint {

	private static final String NAMESPACE = "http://www.wu.com/solargalaxyservice/galaxy";

	@Autowired
	private GreetService greetService;

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE, localPart = "GetGreetRequest")
	public JAXBElement<String> greet() {

		return greetService.greet();

	}

}
