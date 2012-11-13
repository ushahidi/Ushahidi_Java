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
package com.ushahidi.java.sdk.api.tasks;

import com.ushahidi.java.sdk.api.json.Categories;

/**
 * Implements all task related to tagging an existing report with 
 * news item
 * 
 * @author eyedol
 *
 */
public class TagNewsTask extends BaseTask {

	/**
	 * Creates the tagnews task
	 * 
	 * @param url The Ushahidi deployment.
	 */
	public TagNewsTask(String url) {
		super(url);
	}
	
	/**
	 * Tag an existing report with a news article
	 * 
	 * @param id The ID of the existing report
	 * @param url A valid URL that links to an article related to the report
	 */
	public void tagNews(int id, String url) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=tagnews");
		uriBuilder.append("&resp=json");
		
		final Categories categories = fromString(
				client.sendGetRequest(uriBuilder.toString()), Categories.class);
	}
}
