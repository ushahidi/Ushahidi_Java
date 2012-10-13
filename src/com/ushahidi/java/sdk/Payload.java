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
package com.ushahidi.java.sdk;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.ushahidi.java.sdk.api.Model;
import com.ushahidi.java.sdk.net.HttpClient;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * An abstract class to be implemented by all API calls. This is the actual
 * payload as received from the server via an API call.
 * 
 * @author eyedol
 * 
 */
public abstract class Payload<M extends Model> extends UshahidiHttpClient {

	/** The domain of the Ushahidi deployment */
	private String domain;

	/** The error code */
	private int code;

	/** The error message */
	private String message;

	protected final UshahidiHttpClient client;

	private JSONObject jsonObject;

	protected String url;

	protected int timeout;

	/**
	 * Create a payload using the default {@link HttpClient}
	 */
	public Payload(String url) {
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
	public Payload(String url, UshahidiHttpClient client) {
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
	 * Set the domain received from the server
	 * 
	 * @param domain
	 *            the domain from the server.
	 */
	public void setDomain(String domain) {
		if(domain ==null) {
			throw new IllegalArgumentException("domain cannot be null");
		}
		this.domain = domain;
	}

	/**
	 * Get the domain received from the server
	 * 
	 * @return The domain received from the server
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Set the error code received from the server
	 * 
	 * @param code
	 *            The code from the server.
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Get the error code received from the server
	 * 
	 * @return The status code received from the server.
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Set the error message received from the server
	 * 
	 * @param message
	 *            The error message from the server.
	 * 
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the status message received from the server
	 * 
	 * @return The status message as returned from the server
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Abstract method to be implemented by all subclasses so they get the
	 * actual data received from the server via the api call.
	 * 
	 * 
	 * @return The list of model data
	 */
	public abstract List<M> processModels();

	/**
	 * 
	 * @param jsonString
	 */
	public void setJsonObject(String jsonString) throws JSONException {
		if (jsonString != null && jsonString.length() > 0) {
			this.jsonObject = new JSONObject(jsonString);
		}

	}

	/**
	 * 
	 * @return
	 */
	public JSONObject getJsonObject() {
		return this.jsonObject;
	}

	/**
	 * 
	 * @return
	 * @throws JSONException
	 */
	public JSONObject getPayloadObj() throws JSONException {
		return jsonObject.getJSONObject("payload");
	}

}
