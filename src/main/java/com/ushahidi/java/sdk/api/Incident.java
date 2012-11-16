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

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.ushahidi.java.sdk.UshahidiException;

/**
 * The Report class has all the properties and methods of a particular Ushahidi
 * API report resource
 * 
 * @author eyedol
 * 
 */
public class Incident {

	/**
	 * The id of the report
	 */
	@SerializedName("incidentid")
	private int id;

	/**
	 * The title of the report
	 */
	@SerializedName("incidenttitle")
	private String title;

	/**
	 * The description of the report
	 */
	@SerializedName("incidentdescription")
	private String description;

	/**
	 * The date of the report
	 */
	@SerializedName("incidentdate")
	private Incident.Date date;

	/**
	 * The mode of the report
	 */
	@SerializedName("incidentmode")
	private int mode;

	/**
	 * The verification status of the report. 1 for verified and 0 for
	 * unverified.
	 */
	@SerializedName("incidentverified")
	private int verified;

	/**
	 * The location name
	 */
	@SerializedName("locationame")
	private String locationname;

	/**
	 * The latitude attached to the report
	 */
	@SerializedName("locationlatitude")
	private double latitude;

	/**
	 * The longitude attached to the report
	 */
	@SerializedName("locationlongitude")
	private double longitude;

	/**
	 * Report active
	 */
	@SerializedName("incidentactive")
	private int active;


	/**
	 * The default constructor. It initializes no variables.
	 */
	public Incident() {

	}

	/**
	 * Get the report ID
	 * 
	 * @return The report ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the report ID
	 * 
	 * @param id
	 *            The ID of the report
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the title of the report
	 * 
	 * @return The report's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of the report
	 * 
	 * @param title
	 *            The title of the report
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the description of the report
	 * 
	 * @return The description of the report
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the report
	 * 
	 * @param description
	 *            The report description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the date of the report
	 * 
	 * @return The date attached to the report
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the date attached to the report
	 * 
	 * @param date
	 *            The date in the format 2012-09-20 15:06:00
	 */
	public void setDate(java.util.Date date) {
		this.date = new Incident.Date(date);
	}

	/**
	 * Get the mode for the report
	 * 
	 * @return The mode of the report
	 */
	public int getMode() {
		return mode;
	}

	/**
	 * Set the mode of the report
	 * 
	 * @param mode
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}

	/**
	 * Get the verification status of the report. 1 for verified and 0 for
	 * unverified
	 * 
	 * @return The verification status
	 */
	public int getVerified() {
		return verified;
	}

	/**
	 * Set the verification status of the report.
	 * 
	 * @param verified
	 *            The verification status. 1 for verified and 0 for unverified
	 */
	public void setVerified(int verified) {
		this.verified = verified;
	}

	/**
	 * Get the location name attached to the report
	 * 
	 * @return The name of the location
	 */
	public String getLocationName() {
		return locationname;
	}

	/**
	 * Set the location name of the location.
	 * 
	 * @param locationname
	 *            The name of the location
	 */
	public void setLocationName(String locationname) {
		this.locationname = locationname;
	}

	/**
	 * Get the longitude attached to the report
	 * 
	 * @return The longitude tagged with the report
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Set the longitude attached to the report
	 * 
	 * @param longitude
	 *            The longitude of the report
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Get the latitude attached to the report
	 * 
	 * @return The latitude of the report
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Set the latitude attached to the report
	 * 
	 * @param latitude
	 *            The latitude attached to the report
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getActive() {
		return this.active;
	}

	public static class Date extends java.util.Date {

		private static final long serialVersionUID = -2667623647943795029L;

		public Date(java.util.Date date) {
			super(date.getTime());
		}
	}

	public static class DateDeserializer implements JsonDeserializer<Date> {

		private static final SimpleDateFormat PARSER = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		@Override
		public Incident.Date deserialize(JsonElement arg0, Type arg1,
				JsonDeserializationContext arg2) throws JsonParseException {
			try {
				return new Incident.Date(PARSER.parse(arg0.getAsString()));
			} catch (ParseException e) {
				throw new UshahidiException(e);
			}
		}

	}
}
