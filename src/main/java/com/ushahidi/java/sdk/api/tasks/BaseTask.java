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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ushahidi.java.sdk.api.Incident;
import com.ushahidi.java.sdk.net.Authentication;
import com.ushahidi.java.sdk.net.PasswordAuthentication;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * @author eyedol
 * 
 */
public abstract class BaseTask extends UshahidiHttpClient {

	private static Gson gson;
	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Incident.Date.class,
				new Incident.DateDeserializer());
		gson = builder.create();
	}

	/** The Ushahidi deployment URL */
	protected String url;

	/** The task to be performed */
	protected String task;

	private static final String API = "/api";

	private Authentication authentication;

	/**
	 * Create a the task using the default {@link UshahidiHttpClient}
	 * 
	 * @param url
	 *            The Ushahidi deployment
	 * @param task
	 *            The task to be performed
	 */
	public BaseTask(String url, String task) {
		if (url == null) {
			throw new IllegalArgumentException("URL cannot be null");
		}

		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null");
		}

		this.url = url + API;
		this.task = task;
		setRequestParameters("task", task);
		setRequestParameters("resp", "json");
	}

	/**
	 * Get configured http client
	 * 
	 * @return non-null client
	 */
	public UshahidiHttpClient getClient() {
		return this.getClient();
	}

	public void setAuthentication(String username, String password) {
		if (username == null || username.isEmpty()) {
			throw new IllegalArgumentException(
					"Username may not be null or empty");
		}

		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException(
					"Password may not be null or empty");
		}

		authentication = new PasswordAuthentication(username, password);
		setAuthentication(authentication);
	}

	/**
	 * Deserialize the JSON string into Java objects representing the various
	 * Ushahidi models.
	 * 
	 * @param json
	 *            the json string to be converted
	 * @param cls
	 *            the class for the model
	 * @return
	 */
	protected static <T> T fromString(String json, Class<T> cls) {
		return gson.fromJson(json, cls);
	}
}
