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

import java.util.List;

import com.ushahidi.java.sdk.api.Incidents;
import com.ushahidi.java.sdk.api.json.Reports;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

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
public class IncidentsTask extends BaseTask {

	/**
	 * The amount of reports to return at a time. 20 by default
	 */
	public int limit;

	private static final String TASK = "incidents";

	public Reports reports;
	

	/**
	 * Default constructor for ReportsTask. Sets the limit default value to 20.
	 */
	public IncidentsTask(String url) {
		super(url, TASK);
		this.limit = 20;
		client.setRequestParameters("comments", "1");
	}

	public IncidentsTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
		this.limit = 20;
		client.setRequestParameters("comments", "1");
	}

	/**
	 * Get all approved reports
	 * 
	 * @return A List containing all approved reports
	 * 
	 */
	public List<Incidents> all() {
		
		reports = fromString(client.sendGetRequest(url), Reports.class);
		return reports.getIncidents();
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

		client.setRequestParameters("by", "sinceid");
		client.setRequestParameters("id", String.valueOf(id));
		reports = fromString(client.sendGetRequest(url), Reports.class);
		return reports.getIncidents();
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
		client.setRequestParameters("by", "maxid");
		client.setRequestParameters("id", String.valueOf(id));
		reports = fromString(client.sendGetRequest(url), Reports.class);
		return reports.getIncidents();
	}

	/**
	 * Get a report by it's ID
	 * 
	 * @param id
	 *            The ID of the report
	 * @return The details of the reports retrieved.
	 * 
	 */
	public Incidents reportId(int id) {

		client.setRequestParameters("by", "incidentid");
		client.setRequestParameters("id", String.valueOf(id));
		reports = fromString(client.sendGetRequest(url), Reports.class);
		List<Incidents> incidents = reports.getIncidents();

		if (incidents != null && incidents.size() > 0) {
			return incidents.get(0);
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

		client.setRequestParameters("by", "locname");
		client.setRequestParameters("name", name);

		return fromString(client.sendGetRequest(url), Reports.class)
				.getIncidents();
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

		client.setRequestParameters("by", "locid");
		client.setRequestParameters("id", String.valueOf(id));
		reports = fromString(client.sendGetRequest(url), Reports.class);
		return reports.getIncidents();
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

		client.setRequestParameters("by", "catname");
		client.setRequestParameters("name", category);
		reports = fromString(client.sendGetRequest(url), Reports.class);
		return reports.getIncidents();
	}

	/**
	 * Get reports by a category ID.
	 * 
	 * @param id
	 *            The category ID
	 * @return The reports retrieved.
	 */
	public List<Incidents> categoryId(int id) {

		client.setRequestParameters("by", "catid");
		client.setRequestParameters("id", String.valueOf(id));
		reports = fromString(client.sendGetRequest(url), Reports.class);
		return reports.getIncidents();
	}

}
