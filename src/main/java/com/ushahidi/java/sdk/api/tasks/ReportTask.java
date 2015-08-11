package com.ushahidi.java.sdk.api.tasks;

import com.ushahidi.java.sdk.api.ReportFields;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;
import com.ushahidi.java.sdk.net.content.Body;

public class ReportTask extends BaseTask {

	private static final String TASK = "report";

	public ReportTask(String url) {
		super(url, TASK);
	}

	public ReportTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
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
		return fromString(client.sendMultipartPostRequest(url, body),
				Response.class);
	}
}
