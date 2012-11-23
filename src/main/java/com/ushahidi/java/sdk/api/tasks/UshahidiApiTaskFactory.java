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

	private String username;

	private String password;

	/**
	 * Instantiates a new ushahidi api task factory
	 * 
	 * @String
	 */
	private UshahidiApiTaskFactory(String url) {
		this.url = url;
	}

	/**
	 * Get the username to be used for authentication
	 * 
	 * @return The username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Get the password to be used for authentication
	 * 
	 * @return The password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the username to be used for authentication
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Set the password to be used for authentication
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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
		return new CategoriesTask(url);
	}

	/**
	 * Create comments task object.
	 * 
	 * @return The comment task
	 */
	public CommentsTask createCommentTask() {
		return new CommentsTask(url, getUsername(), getPassword());
	}

	/**
	 * Create countries task object
	 * 
	 * @return The countries task
	 */
	public CountriesTask createCountriesTask() {
		return new CountriesTask(url);
	}

	/**
	 * Create location task object
	 * 
	 * @return The location task
	 */
	public LocationTask createLocationTask() {
		return new LocationTask(url);
	}

	/**
	 * Create incidents task object
	 * 
	 * @return The incidents task
	 */
	public IncidentsTask createReportsTask() {
		return new IncidentsTask(url);
	}

	/**
	 * Create the system task object
	 * 
	 * @return The system task
	 */
	public SystemTask createSystemTask() {
		return new SystemTask(url);
	}

	/**
	 * Create the tag news task object
	 * 
	 * @return The tag news task
	 */
	public TagNewsTask createTagNewsTask() {
		return new TagNewsTask(url);
	}

	/**
	 * Create the tag video task object
	 * 
	 * @return The tag video task
	 */
	public TagVideoTask createTagVideoTask() {
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
	public CategoriesAdminTask createCategoriesAdminTask(String username,
			String password) {
		return new CategoriesAdminTask(url, username, password);
	}

	/**
	 * Create the reports admin task
	 * 
	 * 
	 * @return The reports admin task
	 */
	public ReportsAdminTask createReportsAdminTask(String username,
			String password) {
		return new ReportsAdminTask(url, getUsername(), getPassword());
	}

	/**
	 * Create the report task
	 * 
	 * @return The report task
	 */
	public ReportTask createReportTask() {
		return new ReportTask(url);
	}

}
