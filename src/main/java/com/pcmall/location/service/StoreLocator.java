package com.pcmall.location.service;

import com.pcmall.location.RetailStore;

public interface StoreLocator {

	RetailStore findNearest(String ipAddress);
	
}
