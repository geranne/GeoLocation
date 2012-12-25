package com.pcmall.location;

public class IpDbInfoResponse {

	private String statusCode;
	private String statusMessage;
	private String ipAddress;
	private String countryCode;
	private String countryName;
	private String regionName;
	private String cityName;
	private String zipCode;
	private double latitude;
	private double longtitude;
	
	public String getStatusCode() {
		return statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getRegionName() {
		return regionName;
	}

	public String getCityName() {
		return cityName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	@Override
	public String toString() {
		return "IpDbInfoResponse [statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + ", ipAddress="
				+ ipAddress + ", countryCode=" + countryCode + ", countryName="
				+ countryName + ", regionName=" + regionName + ", cityName="
				+ cityName + ", zipCode=" + zipCode + ", latitude=" + latitude
				+ ", longtitude=" + longtitude + "]";
	}

	
}
