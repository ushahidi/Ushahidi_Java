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

/**
 * A factory for creating Ushahidi API task objects.
 * 
 * @author eyedol
 * 
 */
public class UshahidiApiTaskFactory {

	/** The Ushahidi deployment URL **/
	private String url;

	/**
	 * Instantiates a new ushahidi api task factory
	 * 
	 * @String
	 */
	private UshahidiApiTaskFactory(String url) {
		this.url = url;
	}

	/**
	 * Create a new instance of the Ushahidi api task factory
	 * 
	 * @return The Ushahidi API task factory
	 */
	public static UshahidiApiTaskFactory newInstance(String url) {
		return new UshahidiApiTaskFactory(url);
	}

	/**
	 * Create Categories task object
	 * 
	 * @return The categories task
	 */
	public CategoriesTask categories() {
		return new CategoriesTask(url);
	}

	/**
	 * Create comments task object.
	 * 
	 * @return The comment task
	 */
	public CommentsTask comment() {
		return new CommentsTask(url);
	}

	/**
	 * Create countries task object
	 * 
	 * @return The countries task
	 */
	public CountriesTask countries() {
		return new CountriesTask(url);
	}

	/**
	 * Create location task object
	 * 
	 * @return The location task
	 */
	public LocationTask location() {
		return new LocationTask(url);
	}

	/**
	 * Create report task object
	 * 
	 * @return The report task
	 */
	public ReportsTask reports() {
		return new ReportsTask(url);
	}
}
