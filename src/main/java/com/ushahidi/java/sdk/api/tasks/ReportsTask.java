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

import com.ushahidi.java.sdk.api.Category;
import com.ushahidi.java.sdk.api.Incident;
import com.ushahidi.java.sdk.api.Person;
import com.ushahidi.java.sdk.api.ReportFields;
import com.ushahidi.java.sdk.api.json.Reports;
import com.ushahidi.java.sdk.api.json.Reports.Payload.Incidents;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.content.Body;

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

	private static final String TASK = "incidents";

	/**
	 * Default constructor for ReportsTask. Sets the limit default value to 20.
	 */
	public ReportsTask(String url) {
		super(url, TASK);
		this.limit = 20;
		setRequestParameters("comments", "1");
	}

	/**
	 * Get all approved reports
	 * 
	 * @return A List containing all approved reports
	 * 
	 */
	public List<Incidents> all() {

		return fromString(sendGetRequest(url), Reports.class)
				.getPayload().incidents;
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

		setRequestParameters("by", "sinceid");
		setRequestParameters("id", String.valueOf(id));
		return fromString(sendGetRequest(url), Reports.class)
				.getPayload().incidents;
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
		setRequestParameters("by", "maxid");
		setRequestParameters("id", String.valueOf(id));
		return fromString(sendGetRequest(url), Reports.class)
				.getPayload().incidents;
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

		setRequestParameters("by", "incidentid");
		setRequestParameters("id", String.valueOf(id));
		reports = fromString(sendGetRequest(url), Reports.class);
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

		setRequestParameters("by", "locname");
		setRequestParameters("name", name);
		return fromString(sendGetRequest(url), Reports.class)
				.getPayload().incidents;
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

		setRequestParameters("by", "locid");
		setRequestParameters("id", String.valueOf(id));
		return fromString(sendGetRequest(url), Reports.class)
				.getPayload().incidents;
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

		setRequestParameters("by", "catname");
		setRequestParameters("name", category);
		return fromString(sendGetRequest(url), Reports.class)
				.getPayload().incidents;
	}

	/**
	 * Get reports by a category ID.
	 * 
	 * @param id
	 *            The category ID
	 * @return The reports retrieved.
	 */
	public List<Incidents> categoryId(int id) {

		setRequestParameters("by", "catid");
		setRequestParameters("id", String.valueOf(id));
		return fromString(sendGetRequest(url), Reports.class)
				.getPayload().incidents;
	}

	/**
	 * Submit a new report
	 * 
	 * @param report
	 *            The report fields to be submitted
	 * @return The response received from the server
	 */
	public Response submit(ReportFields report) {
		Body body = report.getParameters(report);
		body.addField("task", "report");
		return fromString(sendMultipartPostRequest(url, body),
				Response.class);
	}

	/**
	 * Construct the content to be passed via the admin API calls
	 * 
	 * @param id
	 *            The reports ID
	 * @param action
	 *            The action be performed
	 * @param body
	 *            The content to be submitted.
	 * @return
	 */
	private Body adminBody(int id, String action, Body body) {
		body.addField("task", "reports");
		body.addField("action", action);
		body.addField("incident_id", String.valueOf(id));
		return body;
	}

	/**
	 * Make the HTTP post request
	 * 
	 * @param id
	 *            The reports ID
	 * @param action
	 *            The action be performed
	 * @return
	 */
	private Response admin(int id, String action) {
		Body body = adminBody(id, action, new Body());
		return fromString(this.sendPostRequest(url, body),
				Response.class);

	}

	/**
	 * Delete an existing report.
	 * 
	 * @param id
	 *            The ID of the report to be deleted
	 * @return The response received from the server
	 */
	public Response delete(int id) {
		return admin(id, "delete");
	}

	/**
	 * Verify a report.
	 * 
	 * @param id
	 *            The ID of the report to be verified
	 * @return The response received from the server
	 */
	public Response verify(int id) {
		return admin(id, "verify");
	}

	/**
	 * Approve pending reports. Requires authentication.
	 * 
	 * @param id
	 *            The ID of the pending report
	 * @return The response received from the API call.
	 */
	public Response approve(int id) {
		return admin(id, "approve");
	}

	/**
	 * Edit an existing report. This method requires authentication. Set
	 * {@link #setAuthentication(String, String)} or set {@link #getClient()
	 * .setAuthentication()}
	 * 
	 * @param i
	 *            The incident
	 * @param c
	 *            The categories
	 * @param p
	 *            Personal information
	 * @param news
	 *            Attach news article
	 * @param video
	 *            Attach video article
	 * @return The response received from the API call
	 */
	public Response edit(Incident i, List<Category> c, Person p,
			List<String> news, List<String> video) {
		ReportFields reportFields = new ReportFields();
		reportFields.fill(i);
		reportFields.addCategory(c);
		if (p != null)
			reportFields.setPerson(p);
		if (news != null)
			reportFields.addNews(news);
		if (video != null)
			reportFields.addVideo(video);
		Body body = adminBody(i.getId(), "edit",
				reportFields.getParameters(reportFields));

		// workaround for 2.1
		body.addField("incident_verified", i.getVerified());
		body.addField("incident_active", i.getActive());
		return fromString(sendMultipartPostRequest(url, body),
				Response.class);
	}
}
