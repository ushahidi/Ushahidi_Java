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

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import com.ushahidi.java.sdk.api.json.Reports;
import com.ushahidi.java.sdk.api.json.Reports.Payload.Incidents;

/**
 * The ReportsTask implements all the task related to Reports task.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Reports"
 * >Ushahidi Public API</a>
 * 
 * @author eyedol
 * 
 */
public class ReportsTask extends BaseTask {

	/**
	 * The amount of reports to return at a time. 20 by default
	 */
	public int limit;

	public Reports reports;

	/**
	 * Default constructor for ReportsTask. Sets the limit default value to 20.
	 */
	public ReportsTask(String url) {
		super(url);
		this.limit = 20;
	}

	/**
	 * Get all approved reports
	 * 
	 * @return A List containing all approved reports
	 * 
	 */
	public List<Incidents> all() {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&comments=1");
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		return reports.getPayload().incidents;
	}

	/**
	 * Get all report since a report id was created
	 * 
	 * @param id
	 *            The report ID
	 * @return A List containing all the report since a particular report ID was
	 *         created.
	 */
	public List<Incidents> sinceId(int id) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&comments=1");
		uriBuilder.append("&by=sinceid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		return reports.getPayload().incidents;
	}

	/**
	 * Get all report up to a certain certain report ID
	 * 
	 * @param id
	 *            The report maximum report ID
	 * @return A List containing all the reports within the specified maximum
	 *         report ID.
	 */
	public List<Incidents> maxId(int id) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&comments=1");
		uriBuilder.append("&by=maxid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		return reports.getPayload().incidents;
	}

	/**
	 * Get a report by it's ID
	 * 
	 * @param id
	 *            The ID of the report
	 * @return The details of the reports retrieved.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public Incidents reportId(int id) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&comments=1");
		uriBuilder.append("&by=incidentid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		if (reports.getPayload().incidents != null
				&& reports.getPayload().incidents.size() > 0) {
			return reports.getPayload().incidents.get(0);
		}
		return null;
	}

	/**
	 * Get reports tagged by a location name.
	 * 
	 * @param name
	 *            The name of the location
	 * @return The report retrieved.
	 * 
	 */
	public List<Incidents> locationName(String name) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&by=locname");
		uriBuilder.append("&name=" + name);
		uriBuilder.append("&comments=1");
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		return reports.getPayload().incidents;
	}

	/**
	 * Get reports by a location's ID
	 * 
	 * @param id
	 *            The location ID to use to retrieve the report
	 * @return The reports retrieved.
	 * 
	 */
	public List<Incidents> locationId(int id) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&comments=1");
		uriBuilder.append("&by=locid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		return reports.getPayload().incidents;
	}

	/**
	 * Get reports by a category name.
	 * 
	 * @param category
	 *            The name of the category to use to retrieve the report
	 * @return The reports retrieved.
	 * 
	 */
	public List<Incidents> categoryName(String category) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&comments=1");
		uriBuilder.append("&by=catname");
		uriBuilder.append("&name=" + category);
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		return reports.getPayload().incidents;
	}

	/**
	 * Get reports by a category ID.
	 * 
	 * @param id
	 *            The category ID
	 * @return The reports retrieved.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Incidents> categoryId(int id) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=incidents");
		uriBuilder.append("&comments=1");
		uriBuilder.append("&by=catid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");

		reports = fromString(client.sendGetRequest(uriBuilder.toString()),
				Reports.class);
		return reports.getPayload().incidents;
	}

}
