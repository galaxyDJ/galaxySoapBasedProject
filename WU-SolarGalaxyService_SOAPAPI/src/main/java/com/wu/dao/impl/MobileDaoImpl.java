package com.wu.dao.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wu.dao.play.MobileDao;
import com.wu.entity.Mobile;
import com.wu.entity.MobileFeature;
import com.wu.exception.NoContentFoundException;
import com.wu.exception.RequestViolationException;
import com.wu.solargalaxyservice.galaxy.AddMobileRequest;
import com.wu.solargalaxyservice.galaxy.MobileList;
import com.wu.solargalaxyservice.galaxy.ObjectFactory;

@EnableTransactionManagement
@Repository("mobileDao")
public class MobileDaoImpl implements MobileDao {

	private static final String GET_MOBILE_DETAILS_BY_NAME = "SELECT * FROM TBL_PRODUCT_MOBILE WHERE PRODUCTNAME=:name";
	private static final String GET_MOBILE_DETAILS_BY_ID = "SELECT * FROM TBL_PRODUCT_MOBILE WHERE PRODUCT_MOBILE_ID=:id";
	
	private static final  Map<String,Mobile> MAPMOBILE = new HashMap<String, Mobile>();
	private static final String MOBILE_TO_FROM_SESSION = "mobileToFromSession";
	
	@Autowired
	private HibernateTemplate ht;
	
	@Transactional(value = "hibernateTransactionManager",readOnly = false,propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean saveMobile(MobileFeature mobileFeature) {
		
		long resultValue = (long)ht.save(mobileFeature);
		
		try {
			   new ObjectMapper().writeValueAsString(resultValue);
			
		}catch(IOException ex) {
			
			throw new RequestViolationException("Please pass correct input",ex);
		}
		
		return resultValue>0;
		
	}
	
	@Override
	public List<Mobile> fetchMobileByNameOrWithoutName(String name) {
		 
		EntityManager entityManager = ht.getSessionFactory().createEntityManager();
		Query query = entityManager.createNativeQuery(GET_MOBILE_DETAILS_BY_NAME,Mobile.class);
		List<Mobile> mobileList;
		
		if(name!=null && !name.equals("")) {
			query.setParameter("name", name);
		    mobileList = query.getResultList();
		}else
		    mobileList = ht.loadAll(Mobile.class);
		   
		try {
			new ObjectMapper().writeValueAsString(mobileList);
		}catch(PersistenceException pe) {
			throw new NoContentFoundException("Mobile details are not available",pe);
		}catch(Exception ex) {
			throw new NoContentFoundException("Some issue is raised",ex);
		}
		
		return mobileList;
	
	}
	
	@Override
	public List<MobileFeature> fetchMobile() {
		 
		List<MobileFeature> mobileFeatureList;
		
		    mobileFeatureList = ht.loadAll(MobileFeature.class);
		   
		try {
			new ObjectMapper().writeValueAsString(mobileFeatureList);
		}catch(PersistenceException pe) {
			throw new NoContentFoundException("Mobile details are not available",pe);
		}catch(Exception ex) {
			throw new NoContentFoundException("Some issue is raised",ex);
		}
		
		return mobileFeatureList;
	
	}

	
	@Override
	public Mobile fetchMobileById(long mobileId) {
		
		System.out.println("MobileDaoImpl.fetchMobileById() before if condition");
		if(MAPMOBILE.get(MOBILE_TO_FROM_SESSION)!=null)
		  if(MAPMOBILE.get(MOBILE_TO_FROM_SESSION).getProduct_mobile_id()==mobileId&&MAPMOBILE.get(MOBILE_TO_FROM_SESSION).getProduct_mobile_id()!=null) {
			System.out.println("MobileDaoImpl.fetchMobileById():: from session ::  ");
			return MAPMOBILE.get(MOBILE_TO_FROM_SESSION);
			
		}
		System.out.println("MobileDaoImpl.fetchMobileById()");
		Mobile mobile = ht.get(Mobile.class, mobileId);
		
		try {
			new ObjectMapper().writeValueAsString(mobile);
		}catch(PersistenceException pe) {
			throw new NoContentFoundException("Mobile details are not available",pe);
		}catch(Exception ex) {
			throw new NoContentFoundException("Some issue is raised",ex);
		}
	
		MAPMOBILE.put(MOBILE_TO_FROM_SESSION, mobile);
		
		return mobile;
	
	}
	
	@Transactional(value = "hibernateTransactionManager",readOnly = false,propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean updateMobileById(Mobile mobile) {
		
		ht.saveOrUpdate(mobile);

		try {
			   new ObjectMapper().writeValueAsString(true);
			
		}catch(IOException ex) {
			
			throw new RequestViolationException("Please pass correct input",ex);
		}
		
		MAPMOBILE.clear();

		return true;
	}
	
	@Transactional(value = "hibernateTransactionManager",readOnly = false,propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteMobile(long mobileId) {
		
		Mobile mobile = new Mobile();
		mobile.setProduct_mobile_id(mobileId);
		
		ht.delete(mobile);
		
		try {
			new ObjectMapper().writeValueAsString(true);
		}catch(PersistenceException pe) {
			throw new NoContentFoundException("Mobile details are not available",pe);
		}catch(Exception ex) {
			throw new NoContentFoundException("Some issue is raised",ex);
		}
	
		MAPMOBILE.clear();
		
		return true;
	}
	
}
