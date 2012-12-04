package com.ushahidi.java.sdk.api.tasks;

import java.util.List;

import com.ushahidi.java.sdk.api.Category;
import com.ushahidi.java.sdk.api.Incident;
import com.ushahidi.java.sdk.api.Incidents;
import com.ushahidi.java.sdk.api.Person;
import com.ushahidi.java.sdk.api.ReportFields;
import com.ushahidi.java.sdk.api.json.Reports;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;
import com.ushahidi.java.sdk.net.content.Body;

public class ReportsAdminTask extends BaseTask {
	private static final String TASK = "reports";

	/**
	 * Default constructor for AdminReportsTask.
	 */
	public ReportsAdminTask(String url) {
		super(url, TASK);
	}

	public ReportsAdminTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
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
		return fromString(client.sendPostRequest(url, body), Response.class);

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
		return fromString(client.sendMultipartPostRequest(url, body),
				Response.class);
	}

	private List<Incidents> byStatus(String status) {
		Body body = new Body();
		body.addField("by", status);
		return fromString(client.sendPostRequest(url, body), Reports.class)
				.getIncidents();
	}

	/**
	 * Get approved reports
	 * 
	 * @return The reports retrieved.
	 */
	public List<Incidents> approved() {
		return byStatus("approved");
	}

	/**
	 * Get unapproved reports
	 * 
	 * @return The reports retrieved.
	 */
	public List<Incidents> unapproved() {
		return byStatus("unapproved");
	}

	/**
	 * Get verified reports
	 * 
	 * @return The reports retrieved.
	 */
	public List<Incidents> verified() {
		return byStatus("verified");
	}

	/**
	 * Get unverified reports
	 * 
	 * @return The reports retrieved.
	 */
	public List<Incidents> unverified() {
		return byStatus("unverified");
	}
}
