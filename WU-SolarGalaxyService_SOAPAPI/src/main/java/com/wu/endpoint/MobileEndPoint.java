package com.wu.endpoint;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wu.service.play.MobileService;
import com.wu.solargalaxyservice.galaxy.AddMobileRequest;
import com.wu.solargalaxyservice.galaxy.GetMobileByIdResponse;
import com.wu.solargalaxyservice.galaxy.GetMobileByNameOrWithoutNameResponse;
import com.wu.solargalaxyservice.galaxy.UpdateMobileByIdRequest;

@Endpoint
public class MobileEndPoint {

	private static final String NAMESPACE = "http://www.wu.com/solargalaxyservice/galaxy";
	
	@Autowired
	@Qualifier("mobileService")
	private MobileService mobileService;
	
	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE, localPart = "AddMobileRequest")
	public JAXBElement<Boolean> saveMobile(@RequestPayload AddMobileRequest request){
	//System.out.println("MobileEndPoint.saveMobile():: "+request);
		return mobileService.saveMobile(request);
		
	}
	
	/*
	 * @ResponsePayload
	 * 
	 * @PayloadRoot(namespace = NAMESPACE, localPart =
	 * "GetMobileByNameOrWithoutNameRequest") public
	 * GetMobileByNameOrWithoutNameResponse
	 * getMobileByNameOrWithoutName(@RequestPayload JAXBElement<String> request){
	 * 
	 * return mobileService.getMobileByNameOrWithoutName(request.getValue());
	 * 
	 * }
	 * 
	 * @ResponsePayload
	 * 
	 * @PayloadRoot(namespace = NAMESPACE, localPart = "GetMobileRequest") public
	 * GetMobileByNameOrWithoutNameResponse getMobile(@RequestPayload
	 * JAXBElement<String> request){
	 * 
	 * return mobileService.getMobile();
	 * 
	 * }
	 * 
	 * @ResponsePayload
	 * 
	 * @PayloadRoot(namespace = NAMESPACE, localPart = "GetMobileByIdRequest")
	 * public GetMobileByIdResponse getMobileById(@RequestPayload JAXBElement<Long>
	 * request){
	 * 
	 * return mobileService.getMobileById(request.getValue());
	 * 
	 * }
	 * 
	 * @ResponsePayload
	 * 
	 * @PayloadRoot(namespace = NAMESPACE, localPart = "UpdateMobileByIdRequest")
	 * public JAXBElement<Boolean> saveOrUpdateMobileById(@RequestPayload
	 * UpdateMobileByIdRequest request){
	 * 
	 * return mobileService.saveOrUpdateMobileById(request);
	 * 
	 * }
	 * 
	 * @ResponsePayload
	 * 
	 * @PayloadRoot(namespace = NAMESPACE, localPart = "RemoveMobileByIdRequest")
	 * public JAXBElement<Boolean> removeMobile(@RequestPayload JAXBElement<Long>
	 * request){
	 * 
	 * return mobileService.removeMobile(request.getValue());
	 * 
	 * }
	 * 
	 */}
