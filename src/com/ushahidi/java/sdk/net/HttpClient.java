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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/**
 * This class implements an HTTP client for interacting with Ushahidi Restful
 * API
 * 
 * @author eyedol
 * 
 */
public class HttpClient {

	private static DefaultHttpClient httpClient;

	private HttpParams httpParameters;

	/**
	 * The default connection timeout is 3 secs. You can override this value by
	 * initializing this variable with your own.
	 */
	public int timeoutConnection = 3000;

	/**
	 * The default socket timeout is 3 secs. You can override this value by
	 * initializing this variable with your own.
	 */
	protected int timeoutSocket = 3000;

	/** The default maximum number of connections allowed per host */
	protected static final int DEFAULT_MAX_HOST_CONNECTIONS = 2;

	/** The default maximum number of connections allowed overall */
	protected static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;

	private static final int PLAIN_SOCKET_FACTORY_PORT = 80;

	private static final int SSL_SOCKET_FACTORY_PORT = 443;

	/** Default user agent request header value */
	private static final String USER_AGENT = "Ushahidi-Java/1.0.0";

	/** The user agent to use */
	private String userAgent;

	/** The charset encoding type */
	private static final String CHARSET_UTF8 = "UTF-8";

	private static final int IO_BUFFER_SIZE = 512;

	public HttpClient() {

		httpParameters = new BasicHttpParams();

		httpParameters.setParameter(HttpProtocolParams.USE_EXPECT_CONTINUE,
				false);
		HttpProtocolParams.setVersion(httpParameters, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(httpParameters, "utf8");

		// Set the timeout in milliseconds until a connection is established.
		HttpConnectionParams.setConnectionTimeout(httpParameters,
				timeoutConnection);

		// in milliseconds which is the timeout for waiting for data.
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

		SchemeRegistry schemeRegistry = new SchemeRegistry();

		// http scheme
		schemeRegistry.register(new Scheme("http", PLAIN_SOCKET_FACTORY_PORT,
				PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", SSL_SOCKET_FACTORY_PORT,
				SSLSocketFactory.getSocketFactory()));

		PoolingClientConnectionManager cm = new PoolingClientConnectionManager(
				schemeRegistry);

		// Increase max total connection to 2
		cm.setMaxTotal(DEFAULT_MAX_HOST_CONNECTIONS);

		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(DEFAULT_MAX_TOTAL_CONNECTIONS);

		httpClient = new DefaultHttpClient(cm, httpParameters);
		httpClient.setParams(httpParameters);
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
	 * Get the set user agent
	 * 
	 * @return The set user agent
	 */
	public String getUserAgent() {
		return this.userAgent;
	}

	/**
	 * Sends a GET request to supplied URL
	 * 
	 * @param url
	 *            The URL to send the GET request to.
	 * 
	 * @return The HTTP response object as returned from the server
	 * @throws IOException
	 */
	protected HttpResponse getRequest(String url) throws IOException {

		final HttpGet httpget = new HttpGet(url);
		httpget.addHeader("User-Agent", getUserAgent());

		// Post, check and show the result (not really spectacular, but
		// works):
		HttpResponse response = httpClient.execute(httpget);

		return response;

	}

	/**
	 * Sends a POST request to supplied URL
	 * 
	 * @param url
	 *            The URL to send the POST request to
	 * @param data
	 *            The data to send to the URL
	 * @param Referer
	 *            The referer
	 * @return The HTTP response object as returned from the server
	 * @throws IOException
	 */
	protected HttpResponse postRequest(String url, List<NameValuePair> data,
			String Referer) throws IOException {

		try {
			// wrap try around because this constructor can throw Error
			final HttpPost httpost = new HttpPost(url);
			httpost.addHeader("User-Agent", getUserAgent());
			// org.apache.http.client.methods.
			if (Referer.length() > 0) {
				httpost.addHeader("Referer", Referer);
			}
			if (data != null) {
				try {
					// NEED THIS NOW TO FIX ERROR 417
					httpost.getParams().setBooleanParameter(
							"http.protocol.expect-continue", false);

					httpost.setEntity(new UrlEncodedFormEntity(data,
							CHARSET_UTF8));

				} catch (final UnsupportedEncodingException e) {
					e.printStackTrace();
					return null;
				}
			}

			// Post, check and show the result (not really spectacular, but
			// works):

			HttpResponse response = httpClient.execute(httpost);
			return response;

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Sends a POST request to supplied URL
	 * 
	 * @param url
	 *            The URL to send the POST request to
	 * @param data
	 *            The data to send to the URL
	 * 
	 * @return The HTTP reponse as returned from the server
	 * @throws IOException
	 */
	protected HttpResponse postRequest(String url, List<NameValuePair> data)
			throws IOException {
		return postRequest(url, data, "");
	}

	/**
	 * Make multi part post request
	 * 
	 * @param URL
	 * @param postData
	 * @return
	 * @throws IOException
	 */
	protected HttpResponse multiPartRequest(String URL, MultipartEntity postData)
			throws IOException {
		// wrap try around because this constructor can throw Error
		final HttpPost httpost = new HttpPost(URL);

		if (postData != null) {
			// NEED THIS NOW TO FIX ERROR 417
			httpost.getParams().setBooleanParameter(
					"http.protocol.expect-continue", false);
			httpost.setEntity(postData);
			httpost.addHeader("User-Agent", getUserAgent());
			// Header
			// httpost.addHeader("Authorization","Basic "+
			// getCredentials(userName, userPassword));
			HttpResponse response = httpClient.execute(httpost);
			return response;

		}
		return null;
	}

	protected String getText(HttpResponse response) {
		String text = "";
		try {
			text = getText(response.getEntity().getContent());
		} catch (final Exception ex) {
			ex.printStackTrace();
			return text;
		}
		return text;
	}

	protected String getText(InputStream in) {
		String text = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(in, CHARSET_UTF8), 1024);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		final StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			if (reader != null) {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				text = sb.toString();
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
			return text;
		} finally {
			try {
				in.close();
			} catch (final Exception ex) {
				ex.printStackTrace();
				return text;
			}
		}
		return text;
	}

	public byte[] downloadImage(String address) throws MalformedURLException,
			IOException {

		HttpResponse response;

		try {
			response = getRequest(address);
			int fileSize = (int) response.getEntity().getContentLength();
			if (fileSize < 0) {
				return null;
			}
			byte[] imageData = new byte[fileSize];

			BufferedInputStream istream = new BufferedInputStream(response
					.getEntity().getContent(), IO_BUFFER_SIZE);
			int bytesRead = 0;
			int offset = 0;
			while (bytesRead != -1 && offset < fileSize) {
				bytesRead = istream.read(imageData, offset, fileSize - offset);
				offset += bytesRead;
			}

			// clean up
			istream.close();
			return imageData;
		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}

	/**
	 * Sends a GET request to supplied URL. Converts the input stream as
	 * received from the server to string.
	 * 
	 * @param url
	 *            The URL to send the GET request to.
	 * 
	 * @return The HTTP response string as returned from the server
	 * @throws IOException
	 */
	public String sendGetRequest(String url) throws IOException {

		final HttpResponse response = getRequest(url);
		if (response != null) {
			return getText(response);
		}
		return null;
	}

	/**
	 * Sends a POST request to supplied URL
	 * 
	 * @param url
	 *            The URL to send the POST request to
	 * @param data
	 *            The data to send to the URL
	 * 
	 * @return The HTTP reponse as returned from the server
	 * @throws IOException
	 */
	public String sendPostRequest(String url, List<NameValuePair> data)
			throws IOException {
		final HttpResponse response = postRequest(url, data, "");

		if (response != null) {
			return getText(response);
		}
		return null;
	}

	/**
	 * Sends multi part post request
	 * 
	 * @param URL
	 * @param postData
	 * @return
	 * @throws IOException
	 */
	public String sendmultiPartRequest(String url, MultipartEntity postData)
			throws IOException {
		final HttpResponse response = multiPartRequest(url, postData);

		if (response != null) {
			return getText(response);
		}
		return null;
	}

}
