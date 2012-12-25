package com.pcmall.location.service;

import com.pcmall.location.IpDbInfoResponse;

public interface IpInfoLookUp {

	IpDbInfoResponse getInfo(String ipAddress);
	
}
