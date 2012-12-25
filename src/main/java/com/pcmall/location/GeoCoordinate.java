package com.pcmall.location;

public class GeoCoordinate {

	private double latitude;
	private double longitude;

	public GeoCoordinate(double latitude, double longtitude) {
		this.latitude = latitude;
		this.longitude = longtitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "GeoCoordinate [latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	

}
