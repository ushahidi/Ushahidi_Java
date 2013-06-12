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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.ushahidi.java.sdk.api.json.Date;
import com.ushahidi.java.sdk.api.json.DateDeserializer;
import com.ushahidi.java.sdk.net.Authentication;
import com.ushahidi.java.sdk.net.PasswordAuthentication;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;
import com.ushahidi.java.sdk.util.Validate;

/**
 * @author eyedol
 * 
 */
public abstract class BaseTask {

	private static Gson gson;

	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new DateDeserializer());
		gson = builder.create();
	}

	/** The Ushahidi deployment URL */
	protected String url;

	private static final String API = "/api";

	private Authentication authentication;

	protected UshahidiHttpClient client;

	/**
	 * Create a the task using the default {@link UshahidiHttpClient}
	 * 
	 * @param url
	 *            The Ushahidi deployment
	 * @param task
	 *            The task to be performed
	 * @param client
	 *            The HttpClient
	 */
	public BaseTask(String url, String task, UshahidiHttpClient client) {
		if (url == null) {
			throw new IllegalArgumentException("URL cannot be null");
		}

		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null");
		}

		if (client == null) {
			throw new IllegalArgumentException("Client cannot be null");
		}

		this.url = Validate.removeTrailingSlashes(url) + API;
		this.client = client;
		this.client.setRequestParameters("task", task);
		this.client.setRequestParameters("resp", "json");
	}

	/**
	 * Create a task using the default {@link UshahidiHttpClient}
	 * 
	 * @param url
	 *            The Ushahidi deployment
	 * @param task
	 *            The task to be performed
	 */
	public BaseTask(String url, String task) {
		this(url, task, new UshahidiHttpClient());
	}

	/**
	 * Get configured http client
	 * 
	 * @return non-null client
	 */
	public UshahidiHttpClient getClient() {
		return client;
	}

	public void setAuthentication(String username, String password) {
		if (username == null || username.length() == 0) {
			throw new IllegalArgumentException(
					"Username may not be null or empty");
		}

		if (password == null || password.length() == 0) {
			throw new IllegalArgumentException(
					"Password may not be null or empty");
		}

		authentication = new PasswordAuthentication(username, password);
		client.setAuthentication(authentication);
	}
	
	/**
	 * Return the configured URL
	 * @return
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Deserialize the JSON string into Java objects representing the various
	 * Ushahidi models.
	 * 
	 * @param json
	 *            the json string to be converted
	 * @param cls
	 *            the class for the model
	 * @return The Object related to the Ushahidi API model
	 */
	public static <T> T fromString(String json, Class<T> cls) {
		return gson.fromJson(json, cls);
	}
	
	/**
	 * Deserialize the JSON from a stream object 
	 * 
	 * @param s The stream
	 * @param cls The class for the model
	 * @return The related object
	 */
	public static <T> T fromStream(InputStream s, Class<T> cls) {
		return  cls.cast(gson.fromJson(new JsonReader(new InputStreamReader(s)), cls));

	}

	/**
	 * Deserialize JSON from a URL
	 * 
	 * @param url The URL to the json string
	 * @param cls The class for the model
	 * 
	 * @return The related object
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static <T> T fromUrl(String url, Class<T> cls)
			throws MalformedURLException, IOException {
		return fromStream(new URL(url).openStream(), cls);
	}
	
	/**
	 * Get the configured Gson object.
	 * @return
	 */
	public Gson getGson() {
		return gson;
	}
}
