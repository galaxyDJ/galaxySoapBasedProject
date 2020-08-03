package com.wu.dao.play;

import java.util.List;

import com.wu.entity.Mobile;
import com.wu.entity.MobileFeature;

public interface MobileDao {

	boolean      saveMobile(MobileFeature mobile);
	List<Mobile> fetchMobileByNameOrWithoutName(String name);
	List<MobileFeature> fetchMobile();
	Mobile       fetchMobileById(long mobileId);
	boolean      updateMobileById(Mobile mobile);
	boolean      deleteMobile(long mobileId);
}
