package com.pcmall.location.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.pcmall.location.IpDbInfoResponse;

public class IpInfoLookUpImpl implements IpInfoLookUp {
	
	private static final String UTF_8 = "UTF-8";
	private static final String API_KEY = "a9481328fd9092dd44afb015925949f0c403608af007d473d5e5a8d85f29e924";
	private static final String API_URL = "http://api.ipinfodb.com/v3/ip-city/?key=%s&ip=%s&format=JSON";

	@Override
	public IpDbInfoResponse getInfo(String ipAddress) {
		
		//http://api.ipinfodb.com/v3/ip-city/?key=<your_api_key>&ip=74.125.45.100
			
		Gson gson = new Gson();	
		DefaultHttpClient httpclient = new DefaultHttpClient();
		
		
		String ipDbUrlRequest = String.format(API_URL, API_KEY, ipAddress);
		HttpGet httpGet = new HttpGet(ipDbUrlRequest);
		
		InputStream in = null;
	    try {
			HttpResponse response1 = httpclient.execute(httpGet);
			in = response1.getEntity().getContent();
			
			JsonReader reader = new JsonReader(new InputStreamReader(in, UTF_8));
			reader.setLenient(true);
			//reader.beginObject();
			
			IpDbInfoResponse ipDbInfoResponse = gson.fromJson(reader, IpDbInfoResponse.class);
			
			//reader.endObject();
			reader.close();
			
			return ipDbInfoResponse;
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (in !=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return null;
	}

}
