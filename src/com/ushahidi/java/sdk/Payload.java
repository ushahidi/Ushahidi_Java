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

import com.ushahidi.java.sdk.api.Model;
import com.ushahidi.java.sdk.net.HttpClient;

/**
 * An abstract class to be implemented by all API calls. This is the actual
 * payload as received from the server via an API call.
 * 
 * @author eyedol
 * 
 */
public abstract class Payload<M extends Model> extends HttpClient {

	/** The domain of the Ushahidi deployment */
	private String domain;

	/** The error code */
	private int code;

	/** The error message */
	private String message;

	/** The JSON String retrieved as a result of an API call */
	private String jsonString;

	protected final HttpClient client;

	/**
	 * Create a payload using the default {@link HttpClient}
	 */
	public Payload() {
		this.client = new HttpClient();
	}

	/**
	 * Create the payload for client
	 * 
	 * @param client
	 *            must be non-null
	 */
	public Payload(HttpClient client) {
		if (client == null)
			throw new IllegalArgumentException("Client cannot be null");
		this.client = client;
	}

	/**
	 * Get configured http client
	 * 
	 * @return non-null client
	 */
	public HttpClient getClient() {
		return client;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String getJsonString() {
		return this.jsonString;
	}

	/**
	 * Set the domain received from the server
	 * 
	 * @param domain
	 *            the domain from the server.
	 */
	public void setDomain(String domain) {
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
	 * Abstract method to be implemented by all subclasses so they set the
	 * actual data retrieved from the server via the API. This is the content
	 * most people are interested in.
	 * 
	 * @param List
	 *            <M>
	 * 
	 * @param models
	 *            The items retrieved from the server
	 */
	public abstract void setModels(List<M> models);

	/**
	 * Abstract method to be implemented by all subclasses so they get the
	 * actual data received from the server via the api call.
	 * 
	 * 
	 * @return The list of items
	 */
	public abstract List<M> getModels();

	private void processJson(String jsonString) {

	}
}
