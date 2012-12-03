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

import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * A factory for creating Ushahidi API task objects.
 * 
 * @author eyedol
 * 
 */
public class UshahidiApiTaskFactory {

	/** The Ushahidi deployment URL **/
	private String url;

	public UshahidiHttpClient client = null;

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
	public CategoriesTask createCategoriesTask() {
		if (client != null)
			return new CategoriesTask(url, client);

		return new CategoriesTask(url);
	}

	/**
	 * Create comments task object.
	 * 
	 * @return The comment task
	 */
	public CommentsTask createCommentTask() {
		if (client != null)
			return new CommentsTask(url, client);
		return new CommentsTask(url);
	}

	/**
	 * Create countries task object
	 * 
	 * @return The countries task
	 */
	public CountriesTask createCountriesTask() {
		if (client != null)
			return new CountriesTask(url, client);
		return new CountriesTask(url);
	}

	/**
	 * Create location task object
	 * 
	 * @return The location task
	 */
	public LocationTask createLocationTask() {
		if (client != null)
			return new LocationTask(url, client);
		return new LocationTask(url);
	}

	/**
	 * Create incidents task object
	 * 
	 * @return The incidents task
	 */
	public IncidentsTask createIncidentsTask() {
		if (client != null)
			return new IncidentsTask(url, client);
		return new IncidentsTask(url);
	}

	/**
	 * Create the system task object
	 * 
	 * @return The system task
	 */
	public SystemTask createSystemTask() {
		if (client != null)
			return new SystemTask(url, client);

		return new SystemTask(url);
	}

	/**
	 * Create the tag news task object
	 * 
	 * @return The tag news task
	 */
	public TagNewsTask createTagNewsTask() {
		if (client != null)
			return new TagNewsTask(url, client);
		return new TagNewsTask(url);
	}

	/**
	 * Create the tag video task object
	 * 
	 * @return The tag video task
	 */
	public TagVideoTask createTagVideoTask() {
		if (client != null)
			return new TagVideoTask(url, client);
		return new TagVideoTask(url);
	}

	/**
	 * Create the categories admin task
	 * 
	 * @param username
	 *            The username of the Ushahidi deployment
	 * @param password
	 *            The password of the Ushahidi deployment
	 * 
	 * @return The admin task
	 */
	public CategoriesAdminTask createCategoriesAdminTask() {
		if (client != null)
			return new CategoriesAdminTask(url, client);
		return new CategoriesAdminTask(url);
	}

	/**
	 * Create the reports admin task
	 * 
	 * 
	 * @return The reports admin task
	 */
	public ReportsAdminTask createReportsAdminTask() {
		if (client != null)
			return new ReportsAdminTask(url, client);
		return new ReportsAdminTask(url);
	}

	/**
	 * Create the report task
	 * 
	 * @return The report task
	 */
	public ReportTask createReportTask() {
		if (client != null) {
			return new ReportTask(url, client);
		}
		return new ReportTask(url);
	}

}
