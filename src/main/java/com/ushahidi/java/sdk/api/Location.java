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

import com.ushahidi.java.sdk.api.json.Date;

/**
 * The Location class has all the properties and methods of the Ushahidi API's
 * location resource
 * 
 * @author eyedol
 * 
 */
public class Location {

	/**
	 * The name of the location. Eg. Accra.
	 */
	private String name;

	/**
	 * The country ID
	 */
	private int countryId;

	/**
	 * The location name. Eg. Accra. This is to accommodate backward compability
	 * with the old API
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
	private Date date;

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

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(java.util.Date date) {
		this.date = new Date(date);
	}

	@Override
	public String toString() {
		return "Location [name:" + name + ", countryId:" + countryId
				+ ", locationName" + ", latitude:" + latitude + ", longitude:"
				+ longitude + ", date:" + date + "]";
	}
}
