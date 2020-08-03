package com.wu.service.play;

import javax.xml.bind.JAXBElement;

import com.wu.solargalaxyservice.galaxy.AddMobileRequest;
import com.wu.solargalaxyservice.galaxy.GetMobileByIdResponse;
import com.wu.solargalaxyservice.galaxy.GetMobileByNameOrWithoutNameResponse;
import com.wu.solargalaxyservice.galaxy.UpdateMobileByIdRequest;

public interface MobileService {

	JAXBElement<Boolean>                  saveMobile(AddMobileRequest mobileRequest);
	GetMobileByNameOrWithoutNameResponse  getMobileByNameOrWithoutName(String name);
	GetMobileByNameOrWithoutNameResponse  getMobile();
	GetMobileByIdResponse                 getMobileById(long mobileId);
	JAXBElement<Boolean>                  saveOrUpdateMobileById(UpdateMobileByIdRequest updateMobile);
	JAXBElement<Boolean>                  removeMobile(long mobileId);
}
