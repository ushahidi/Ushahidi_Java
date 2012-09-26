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
	private String mode;

	/**
	 * The verification status of the report. 1 for verified and 0 for unverified.
	 */
	private String verified;

	/**
	 * The location name
	 */
	private String locationname;

	/**
	 * The latitude attached to the report
	 */
	private String latitude;

	/**
	 * The longitude attached to the report
	 */
	private String longitude;

	
	/**
	 * The list of categories attached to the report
	 */
	private List<Category> categories;

	private String media;

	public Report() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReportDate() {
		return date;
	}

	public void setReportDate(String reportdate) {
		this.date = reportdate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getLocationName() {
		return locationname;
	}

	public void setLocationName(String locationname) {
		this.locationname = locationname;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getMedia() {
		return this.media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public void setDbId(int id) {
		this.id = id;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getReportId() {
		return this.reportId;
	}
	
	public void setPending(int pending) {
		this.pending = pending;
	}

	public int getPending() {
		return this.pending;
	}
}
