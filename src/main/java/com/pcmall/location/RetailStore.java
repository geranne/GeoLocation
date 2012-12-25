package com.pcmall.location;

public class RetailStore {

	private String name;
	private String address;
	private GeoCoordinate geoCoordinate;
	
	public RetailStore(String name, String address, GeoCoordinate geoCoordinate) {
		this.name = name;
		this.address = address;
		this.geoCoordinate = geoCoordinate;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public GeoCoordinate getGeoCoordinate() {
		return geoCoordinate;
	}

	@Override
	public String toString() {
		return "RetailStore [name=" + name + ", address=" + address
				+ ", geoCoordinate=" + geoCoordinate + "]";
	}

	
}
