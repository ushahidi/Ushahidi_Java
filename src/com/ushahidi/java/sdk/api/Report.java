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

import java.util.List;

/**
 * The report class has all the properties and methods of a particular class
 * 
 * @author eyedol
 *
 */
public class Report {
	
	/**
	 * The id of the report
	 */
	private int id;

	/**
	 * The title of the report
	 */
	private String title;

	/**
	 * The description of the report
	 */
	private String description;

	/**
	 * The date of the report
	 */
	private String date;

	/**
	 * The mode of the report
	 */
	private int mode;

	/**
	 * The verification status of the report. 1 for verified and 0 for unverified.
	 */
	private int verified;

	/**
	 * The location name
	 */
	private String locationname;

	/**
	 * The latitude attached to the report
	 */
	private double latitude;

	/**
	 * The longitude attached to the report
	 */
	private double longitude;

	
	/**
	 * The list of categories attached to the report
	 */
	private List<Category> categories;

	/**
	 * The media attached to the report
	 */
	private List<Media> media;
	
	/**
	 * The comments attached to the report
	 */
	private List<Comment> comments;

	/**
	 * The default constructor. It initializes no variables.
	 */
	public Report() {

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
	 * @param id The ID of the report
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
	 * @param title The title of the report
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
	 * @param description The report description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the date of the report
	 * 
	 * @return The date attached to the report
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set the date attached to the report
	 * 
	 * @param date The date in the format 2012-09-20 15:06:00
	 */
	public void setDate(String date) {
		this.date = date;
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
	 * Get the verification status of the report. 1 for verified and 0 for unverified
	 * 
	 * @return
	 */
	public int getVerified() {
		return verified;
	}

	/**
	 * Set the verification status of the report.
	 * 
	 * @param verified The verification status. 1 for verified and 0 for unverified
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
	 * @param locationname The name of the location
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
	 * @param longitude The longitude of the report
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
	 * @param latitude The latitude attached to the report
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get a list of categories tagged to the report
	 * 
	 * @return The list of categories attached to the report.
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * Set the list of categories.
	 * 
	 * @param categories The categories attached to the report
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * Get the media attached to the report
	 * 
	 * @return The media attached to the report
	 */
	public List<Media> getMedia() {
		return this.media;
	}

	/**
	 * Set the media attached to the report.
	 * 
	 * @param media The media attached to the report
	 */
	public void setMedia( List <Media> media) {
		this.media = media;
	}

	/**
	 * Get the comments attached to the report
	 * 
	 * @return The comment attached to the report
	 */
	public List<Comment> getComments() {
		return this.comments;
	}

	/**
	 * Set the comments attached to the report.
	 * 
	 * @param comments The media attached to the report
	 */
	public void setComments( List <Comment> comments) {
		this.comments = comments;
	}
}
