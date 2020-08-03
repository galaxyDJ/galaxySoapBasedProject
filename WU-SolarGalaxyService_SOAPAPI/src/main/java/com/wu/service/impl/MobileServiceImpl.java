package com.wu.service.impl;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wu.dao.play.MobileDao;
import com.wu.entity.Mobile;
import com.wu.entity.MobileFeature;
import com.wu.service.play.MobileService;
import com.wu.solargalaxyservice.galaxy.AddMobileRequest;
import com.wu.solargalaxyservice.galaxy.GetMobileByIdResponse;
import com.wu.solargalaxyservice.galaxy.GetMobileByNameOrWithoutNameResponse;
import com.wu.solargalaxyservice.galaxy.MobileList;
import com.wu.solargalaxyservice.galaxy.ObjectFactory;
import com.wu.solargalaxyservice.galaxy.UpdateMobileByIdRequest;

@Service("mobileService")
public class MobileServiceImpl implements MobileService {

	@Autowired
	@Qualifier("mobileDao")
	private MobileDao mobileDao;

	@Override
	public JAXBElement<Boolean> saveMobile(AddMobileRequest mobileRequest) {

		MobileFeature mobileFeatureEntity = new MobileFeature();
		BeanUtils.copyProperties(mobileRequest.getMobileFeature(), mobileFeatureEntity);
		mobileFeatureEntity.setBattaryPower(mobileRequest.getMobileFeature().getBatteryPower());
		Mobile mobile = new Mobile();
		BeanUtils.copyProperties(mobileRequest, mobile);
		mobile.setProduct_mobile_id(mobileRequest.getProductMobileId());
		
		mobileFeatureEntity.setMobile(mobile);
		mobileFeatureEntity.setRam(mobileRequest.getMobileFeature().getRam());
		boolean result = mobileDao.saveMobile(mobileFeatureEntity);
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<Boolean> resultValue = factory.createAddMobileResponse(result);

		return resultValue;

	}

	@Override
	public GetMobileByNameOrWithoutNameResponse getMobileByNameOrWithoutName(String name) {

		List<Mobile>                         listMobile     = mobileDao.fetchMobileByNameOrWithoutName(name);
		GetMobileByNameOrWithoutNameResponse response       = new GetMobileByNameOrWithoutNameResponse();
		List<MobileList>                     listMobileResp = response.getMobileList();
		MobileList                           mobileList;
		
		for (Mobile mobile : listMobile) {
			mobileList = new MobileList();
			BeanUtils.copyProperties(mobile, mobileList);
			mobileList.setProductMobileId(mobile.getProduct_mobile_id());

			listMobileResp.add(mobileList);
		
		}

		return response;

	}
	
	@Override
	public GetMobileByNameOrWithoutNameResponse getMobile() {

		List<MobileFeature>                         listMobileFeature     = mobileDao.fetchMobile();
		GetMobileByNameOrWithoutNameResponse response       = new GetMobileByNameOrWithoutNameResponse();
		List<MobileList>                     listMobileResp = response.getMobileList();
		MobileList                           mobileList;
		List<com.wu.solargalaxyservice.galaxy.MobileFeature> listMobileFeatureResp = response.getMobileFeature();
		com.wu.solargalaxyservice.galaxy.MobileFeature mobileFeatureList;
		
		for (MobileFeature mobileFeature : listMobileFeature) {
			mobileList = new MobileList();
			mobileFeatureList = new com.wu.solargalaxyservice.galaxy.MobileFeature();
			BeanUtils.copyProperties(mobileFeature.getMobile(), mobileList);
			BeanUtils.copyProperties(mobileFeature, mobileFeatureList);
			mobileList.setProductMobileId(mobileFeature.getMobile().getProduct_mobile_id());
			mobileFeatureList.setBatteryPower(mobileFeature.getBattaryPower());
            listMobileFeatureResp.add(mobileFeatureList);
			listMobileResp.add(mobileList);
		
		}

		return response;

	}

	@Override
	public GetMobileByIdResponse getMobileById(long mobileId) {
		
		GetMobileByIdResponse response = new GetMobileByIdResponse();
		Mobile mobile = mobileDao.fetchMobileById(mobileId);
		
		BeanUtils.copyProperties(mobile, response);
		response.setProductMobileId(mobile.getProduct_mobile_id());
		return response;
	
	}
	
	@Override
	public JAXBElement<Boolean> saveOrUpdateMobileById(UpdateMobileByIdRequest updateMobile) {
		
		Mobile mobile = new Mobile();
		ObjectFactory factory = new ObjectFactory();
		
		BeanUtils.copyProperties(updateMobile,mobile);
		mobile.setProduct_mobile_id(updateMobile.getProductMobileId());
		boolean value = mobileDao.updateMobileById(mobile);
		
		
		return factory.createUpdateMobileByIdResponse(value);
	}
	
	@Override
	public JAXBElement<Boolean> removeMobile(long mobileId) {
		
		
		ObjectFactory factory = new ObjectFactory();
		
		
		boolean value = mobileDao.deleteMobile(mobileId);
	
		return factory.createRemoveMobileByIdResponse(value);
	
	}

}
