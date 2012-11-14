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

import com.ushahidi.java.sdk.annotations.Form;
import com.ushahidi.java.sdk.annotations.FormField;

/**
 * Holds form fields for tagging a video article to an existing report
 * 
 * @author eyedol
 * 
 */
public class TagVideoFields extends Form {

	/**
	 * The ID of the report to tag the video
	 */
	@FormField(name = "id")
	private int id;

	/**
	 * The URL of the video to be tagged to the existing report
	 */
	@FormField(name = "url")
	private String url;

	/**
	 * Tag video
	 * 
	 * @param id The report id
	 * @param url The video URL
	 */
	public TagVideoFields(int id, String url) {
		this.id = id;
		this.url = url;
	}
}
