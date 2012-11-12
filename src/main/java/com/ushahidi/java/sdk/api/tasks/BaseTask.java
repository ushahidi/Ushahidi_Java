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
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * @author eyedol
 * 
 */
public abstract class BaseTask extends UshahidiHttpClient {

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	/** The HTTP client */
	protected final UshahidiHttpClient client;

	/** The Ushahidi deployment URL */
	protected String url;

	/**
	 * Create a the task using the default {@link UshahidiHttpClient}
	 */
	public BaseTask(String url) {
		if (url == null) {
			throw new IllegalArgumentException("URL cannot be null");
		}
		this.url = url;
		this.client = new UshahidiHttpClient();
	}

	/**
	 * Create the payload for client
	 * 
	 * @param client
	 *            must be non-null
	 */
	public BaseTask(String url, UshahidiHttpClient client) {
		if (client == null) {
			throw new IllegalArgumentException("Client cannot be null");
		}
		this.client = client;
		this.url = url;
	}

	/**
	 * Get configured http client
	 * 
	 * @return non-null client
	 */
	public UshahidiHttpClient getClient() {
		return client;
	}

	/**
	 * Deserialize the JSON string into Java objects representing the various 
	 * Ushahidi models.
	 * 
	 * @param json the json string to be converted
	 * @param cls the class for the model
	 * @return
	 */
	protected static <T> T fromString(String json, Class<T> cls) {
		return gson.fromJson(json, cls);
	}
}
