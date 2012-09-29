/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 *****************************************************************************/
package com.ushahidi.java.sdk.api;

/**
 * @author eyedol
 *
 */
public class Location {
	
	/**
	 * The location's unique  ID as retrieved via the API
	 */
	private int id;

	/**
	 * The name of the location. Eg. Accra.
	 */
	private String name;
	
	/**
	 * The country ID
	 */
	private int countryId;
	
	/**
	 * The location name. Eg. Accra. This is to accommodate backward compability with 
	 * the old API
	 */
	private String locationName;
	
	/**
	 * The latitude of the location
	 */
	private double latitude;
	
	/**
	 * The longitude of the location
	 */
	private double longitude;
	
	/**
	 * The date and time the location was saved. Eg. 2009-06-30 00:00:00
	 */
	private String date;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCountryId() {
		return countryId;
	}
	
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
