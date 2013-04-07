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
package com.ushahidi.java.sdk.net;

import java.io.IOException;
import java.io.InputStream;

import com.ushahidi.java.sdk.UshahidiException;
import com.ushahidi.java.sdk.net.content.Body;

/**
 * The main HTTP Client to interact with the Ushahidi API
 * 
 * @author eyedol
 * 
 */
public class UshahidiHttpClient extends BaseUshahidiHttpClient {

	/** Default user agent request header value */
	private static final String USER_AGENT = "Ushahidi-Java/1.0.0";

	/** The user agent to use */
	private String userAgent = null;

	public UshahidiHttpClient() {
		requestHeaders.put("Accept-Encoding", "gzip, deflate");
	}

	/**
	 * Set the value to set as the user agent header on every request created.
	 * Specifying a null or empty agent parameter will reset this client to use
	 * the default user agent header value.
	 * 
	 * @param agent
	 */
	public void setUserAgent(String agent) {
		if (agent != null && agent.length() > 0) {
			userAgent = agent;
		} else {
			userAgent = USER_AGENT;
		}
	}

	/**
	 * Get the user agent
	 * 
	 * @return The user agent
	 */
	public String getUserAgent() {
		if (userAgent != null && userAgent.length() > 0) {
			return this.userAgent;
		}
		return USER_AGENT;
	}

	/**
	 * Sends a GET request to the supplied URL. Converts the input stream as
	 * received from the server to string.
	 * 
	 * @param url
	 *            The URL to send the GET request to.
	 * 
	 * @return The HTTP response string as returned from the server
	 * @throws IOException
	 */
	public String sendGetRequest(String url) {
		InputStream inputStream = null;
		try {
			addRequestHeader("User-Agent", getUserAgent());
			inputStream = getRequest(url);
			
			if (inputStream != null) {
				return streamToString(inputStream);
			} else {
				
				throw new UshahidiException(
						"Unknown content found in response.");
			}
			
		} catch (Exception e) {
			throw new UshahidiException(e);
		} finally {
			closeStream(inputStream);
		}

	}

	/**
	 * Sends a POST request to the supplied URL. Converts the input stream as
	 * received from the server to string.
	 * 
	 * @param url
	 *            The URL to send the POST request to.
	 * @param body
	 *            The form fields to be sent
	 * 
	 * @return The HTTP response string as returned from the server
	 * @throws IOException
	 */
	public String sendPostRequest(String url, Body body) {
		InputStream inputStream = null;
		try {
			addRequestHeader("User-Agent", getUserAgent());
			inputStream = postRequest(url, body);

			if (inputStream != null) {
				return streamToString(inputStream);
			} else {
				throw new UshahidiException(
						"Unknown content found in response.");
			}
		} catch (Exception e) {
			throw new UshahidiException(e);
		} finally {
			closeStream(inputStream);
		}

	}

	/**
	 * Sends a POST request to the supplied URL. Converts the input stream as
	 * received from the server to string.
	 * 
	 * @param url
	 *            The URL to send the POST request to.
	 * 
	 * @return The HTTP response string as returned from the server
	 * @throws IOException
	 */
	public String sendPostRequest(String url) {
		InputStream inputStream = null;
		try {
			addRequestHeader("User-Agent", getUserAgent());
			inputStream = postRequest(url);

			if (inputStream != null) {
				return streamToString(inputStream);
			} else {
				throw new UshahidiException(
						"Unknown content found in response.");
			}
		} catch (Exception e) {
			throw new UshahidiException(e);
		} finally {
			closeStream(inputStream);
		}

	}

	/**
	 * Sends a POST request to the supplied URL. Converts the input stream as
	 * received from the server to string.
	 * 
	 * @param url
	 *            The URL to send the POST request to.
	 * @param body
	 *            The parameters to
	 * 
	 * @return The HTTP response string as returned from the server
	 * @throws IOException
	 */
	public String sendMultipartPostRequest(String url, Body body) {
		InputStream inputStream = null;
		try {
			addRequestHeader("User-Agent", getUserAgent());
			addRequestHeader("Connection", "Keep-Alive");
			inputStream = postMultipartRequest(url, body);

			if (inputStream != null) {
				return streamToString(inputStream);
			} else {
				throw new UshahidiException(
						"Unknown content found in response.");
			}
		} catch (Exception e) {
			throw new UshahidiException(e);
		} finally {
			closeStream(inputStream);
		}

	}

	/**
	 * Set the request parameters
	 * 
	 * @param key
	 *            The variable name
	 * @param value
	 *            The variable value
	 */
	public void setRequestParameters(String key, String value) {
		requestParameters.put(key, value);
	}
}
