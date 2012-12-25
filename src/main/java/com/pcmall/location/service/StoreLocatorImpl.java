package com.pcmall.location.service;

import java.util.ArrayList;
import java.util.List;

import com.pcmall.location.GeoCoordinate;
import com.pcmall.location.GeoLocationUtil;
import com.pcmall.location.IpDbInfoResponse;
import com.pcmall.location.RetailStore;

public class StoreLocatorImpl implements StoreLocator {
	
	static List<RetailStore> retailStores = new ArrayList<RetailStore>();
	static IpInfoLookUp ipInfoLookUp = new IpInfoLookUpImpl();
	
	static {
		retailStores.add(
						new RetailStore("Torrance",
										"22719 Hawthorne Blvd. Torrance, CA 90505",
										new GeoCoordinate(33.821422,-118.351352)));
		
		
	}
	
	

	@Override
	public RetailStore findNearest(String ipAddress) {

		IpDbInfoResponse ipInfo = ipInfoLookUp.getInfo(ipAddress);
		RetailStore nearestStore = null;
		
		
		//initialize nearestDistance with double's maximum value;
		double nearestDistance = Double.MAX_VALUE;
		
		for (RetailStore currentStore : retailStores) {
			
			GeoCoordinate point1 = currentStore.getGeoCoordinate();
			GeoCoordinate point2 = new GeoCoordinate(ipInfo.getLatitude(), ipInfo.getLongtitude());
			
			double newDistance = GeoLocationUtil.getDistance(point1, point2); 
			
			if (newDistance < nearestDistance) {
				
				nearestStore = currentStore;
				nearestDistance = newDistance;
			}
						
		}
		return nearestStore;
	}

}
