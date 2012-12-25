package com.pcmall.location;

/**
 * This class computes for the Great-circle distance between two geographic points
 * using the ‘haversine’ formula.
 * 
 * Reference : http://www.movable-type.co.uk/scripts/latlong.html
 * 
 * @author Geranne
 */
public class GeoLocationUtil {

	private static final double MEAN_EARTH_RADIUS = 6371; // (Earth's mean radius = 6,371km)
	
	private GeoLocationUtil(){};
	
	public static double getDistance(GeoCoordinate point1, GeoCoordinate point2) {
		
		double dLatitude = Math.toRadians(point2.getLatitude() - point1.getLatitude());
		double dLongtitude = Math.toRadians(point2.getLongitude() - point1.getLongitude());	
		double latitude1 = Math.toRadians(point1.getLatitude());
		double latitude2 =	Math.toRadians(point2.getLatitude());
		
		double a = Math.pow(Math.sin(dLatitude/2), 2) 
				 + Math.pow(Math.sin(dLongtitude/2), 2) 
				 * Math.cos(latitude1) 
				 * Math.cos(latitude2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		return MEAN_EARTH_RADIUS * c;
	}
	
}
/*
var R = 6371; // km
var dLat = (lat2-lat1).toRad();
var dLon = (lon2-lon1).toRad();
var lat1 = lat1.toRad();
var lat2 = lat2.toRad();

var a = Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
var d = R * c;
*/
