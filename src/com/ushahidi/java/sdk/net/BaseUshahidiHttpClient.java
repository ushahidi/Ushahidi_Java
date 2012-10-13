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
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.ushahidi.java.sdk.UshahidiException;

/**
 * @author eyedol
 * 
 */
public abstract class BaseUshahidiHttpClient {
	protected final Logger logger = Logger.getLogger(getClass()
			.getCanonicalName());
	/** The Constant GZIP_ENCODING. */
	private static final String GZIP_ENCODING = "gzip";

	/** The Constant REFERRER. */
	private static final String REFERRER = "Referer";

	/** The request headers. */
	protected Map<String, String> requestHeaders = new HashMap<String, String>();

	/** The request parameters. */
	protected Map<String, String> requestParameters = new HashMap<String, String>();

	/** The charset encoding type */
	private static final String CHARSET_UTF8 = "UTF-8";

	/**
	 * The default connection timeout is 3 secs. You can override this value by
	 * initializing this variable with your own.
	 */
	private int connectionTimeout = 0;

	/**
	 * The default socket timeout is 3 secs. You can override this value by
	 * initializing this variable with your own.
	 */
	private int socketTimeout = 0;

	private static final int TIMEOUT = 3000;

	/**
	 * Sets the request headers.
	 * 
	 * @param requestHeaders
	 *            the request headers
	 */
	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	/**
	 * Gets the request headers.
	 * 
	 * @return the request headers
	 */
	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	/**
	 * Adds the request header.
	 * 
	 * @param headerName
	 *            the header name
	 * @param headerValue
	 *            the header value
	 */
	public void addRequestHeader(String headerName, String headerValue) {
		requestHeaders.put(headerName, headerValue);
	}

	/**
	 * Removes the request header.
	 * 
	 * @param headerName
	 *            the header name
	 */
	public void removeRequestHeader(String headerName) {
		requestHeaders.remove(headerName);
	}

	/**
	 * Sets the referrer.
	 * 
	 * @param referrer
	 *            the new referrer
	 */
	public void setReferrer(String referrer) {
		requestHeaders.put(REFERRER, referrer);
	}

	/**
	 * Set the default connection timeout. The default connection timeout is 3
	 * secs.
	 * 
	 * @param timeoutConnection
	 *            The connection timeout in miliseconds
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		if (connectionTimeout > 0) {
			this.connectionTimeout = connectionTimeout;
		} else {
			this.connectionTimeout = TIMEOUT;
		}
	}

	/**
	 * Get the default connection timeout.
	 * 
	 * @return The set connection timeout
	 */
	public int getConnectionTimeout() {
		return this.connectionTimeout;
	}

	/**
	 * Set the default socket timeout. The default socket timeout is 3 secs.
	 * 
	 * @param timeoutConnection
	 *            An int that specifies the socket timeout value in milliseconds
	 */
	public void setSocketTimeout(int socketTimeout) {
		if (socketTimeout > 0) {
			this.socketTimeout = socketTimeout;
		} else {
			this.socketTimeout = TIMEOUT;
		}
	}

	/**
	 * Get the default socket timeout.
	 * 
	 * @return
	 */
	public int getSocketTimeout() {
		return this.socketTimeout;
	}

	/**
	 * Sets the authentication.
	 * 
	 * @param authentication
	 *            the new authentication
	 */
	/*
	 * public void setAuthentication(Authentication authentication) { if
	 * (authentication != null) { if (authentication instanceof
	 * ParameterBasedAuthentication) { requestParameters
	 * .putAll(((ParameterBasedAuthentication) authentication)
	 * .getParameters()); } else if (authentication instanceof
	 * HeaderBasedAuthentication) { requestHeaders
	 * .putAll(((HeaderBasedAuthentication) authentication) .getHeaders()); } }*
	 * }
	 */

	/**
	 * Convert stream to string.
	 * 
	 * @param is
	 *            the is
	 * 
	 * @return the string
	 */
	protected static String streamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	/**
	 * Call a GET request.
	 * 
	 * @param url
	 *            the api url
	 * 
	 * @return the input stream
	 */
	protected InputStream getRequest(String url) {
		return getRequest(url, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call a POST request
	 * 
	 * @param url
	 * 
	 * @return the input stream
	 */
	protected InputStream postRequest(String url, Map<String, String> parameters) {
		return postRequest(url, parameters, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call a POST request
	 * 
	 * @param url
	 * 
	 * @return the input stream
	 */
	protected InputStream postMultipartRequest(String url,
			Map<String, String> parameters, String fileName) {
		return postMultipartRequest(url, parameters, fileName,
				HttpURLConnection.HTTP_OK);
	}

	/**
	 * Make a GET request.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream getRequest(String apiUrl, int expected) {
		try {
			URL url = new URL(apiUrl);
			if (!requestParameters.isEmpty()) {
				if (url.getQuery() == null) {
					url = new URL(apiUrl + "?"
							+ getParametersString(requestParameters));
				} else {
					url = new URL(apiUrl + "&"
							+ getParametersString(requestParameters));
				}
			}

			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();
			request.setConnectTimeout(getConnectionTimeout());
			request.setReadTimeout(getSocketTimeout());

			for (String headerName : requestHeaders.keySet()) {
				request.setRequestProperty(headerName,
						requestHeaders.get(headerName));
			}

			request.connect();

			if (request.getResponseCode() != expected) {
				throw new UshahidiException(
						streamToString(getWrappedInputStream(
								request.getErrorStream(),
								GZIP_ENCODING.equalsIgnoreCase(request
										.getContentEncoding()))));
			} else {
				return getWrappedInputStream(request.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));
			}
		} catch (IOException e) {
			throw new UshahidiException(e);
		}
	}

	/**
	 * Make a POST request.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param parameters
	 *            the parameters
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream postRequest(String apiUrl,
			Map<String, String> parameters, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();

			request.setConnectTimeout(getConnectionTimeout());
			request.setReadTimeout(getSocketTimeout());

			for (String headerName : requestHeaders.keySet()) {
				request.setRequestProperty(headerName,
						requestHeaders.get(headerName));
			}

			parameters.putAll(requestParameters);

			request.setRequestMethod("POST");
			request.setDoOutput(true);

			PrintStream out = new PrintStream(new BufferedOutputStream(
					request.getOutputStream()));

			out.print(getParametersString(parameters));
			out.flush();
			out.close();

			request.connect();

			if (request.getResponseCode() != expected) {
				throw new UshahidiException(
						streamToString(getWrappedInputStream(
								request.getErrorStream(),
								GZIP_ENCODING.equalsIgnoreCase(request
										.getContentEncoding()))));
			} else {
				return getWrappedInputStream(request.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));
			}
		} catch (IOException e) {
			throw new UshahidiException(e);
		} finally {
		}
	}

	/**
	 * Gets the parameters string.
	 * 
	 * @param parameters
	 *            the parameters
	 * 
	 * @return the parameters string
	 */
	protected String getParametersString(Map<String, String> parameters) {
		StringBuilder builder = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> iterator = parameters
				.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = iterator.next();
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(encodeUrl(entry.getValue()));
			if (iterator.hasNext()) {
				builder.append("&");
			}
		}

		return builder.toString();
	}

	/**
	 * Make a POST request.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param parameters
	 *            the parameters
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream postMultipartRequest(String apiUrl,
			Map<String, String> parameters, String fileName, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();

			DataOutputStream dos = null;
			String lineEnd = "\r\n";
			String twoHyphens = "--";
			String boundary = "*****";
			int bytesRead, bytesAvailable, bufferSize;
			byte[] buffer;
			int maxBufferSize = 1 * 1024 * 1024;

			request.setConnectTimeout(getConnectionTimeout());
			request.setReadTimeout(getSocketTimeout());

			for (String headerName : requestHeaders.keySet()) {
				request.setRequestProperty(headerName,
						requestHeaders.get(headerName));
			}

			parameters.putAll(requestParameters);

			request.setRequestMethod("POST");
			request.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
			request.setDoOutput(true);
			// Allow Inputs
			request.setDoInput(true);

			// upload files
			if (fileName != null && fileName.length() > 0) {
				FileInputStream fileInputStream = new FileInputStream(new File(
						fileName));
				dos = new DataOutputStream(request.getOutputStream());
				dos.writeBytes(twoHyphens + boundary + lineEnd);

				dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\""
						+ fileName + "\"" + lineEnd); // uploaded_file_name
														// is the Name
														// of the File
														// to be
														// uploaded
				dos.writeBytes(lineEnd);
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				buffer = new byte[bufferSize];
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				while (bytesRead > 0) {
					dos.write(buffer, 0, bufferSize);
					bytesAvailable = fileInputStream.available();
					bufferSize = Math.min(bytesAvailable, maxBufferSize);
					bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				}
				dos.writeBytes(lineEnd);
				dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
				fileInputStream.close();
				dos.flush();
				dos.close();
			}

			PrintStream out = new PrintStream(new BufferedOutputStream(
					request.getOutputStream()));

			out.print(getParametersString(parameters));
			out.flush();
			out.close();

			request.connect();

			if (request.getResponseCode() != expected) {
				throw new UshahidiException(
						streamToString(getWrappedInputStream(
								request.getErrorStream(),
								GZIP_ENCODING.equalsIgnoreCase(request
										.getContentEncoding()))));
			} else {
				return getWrappedInputStream(request.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));
			}
		} catch (IOException e) {
			throw new UshahidiException(e);
		} finally {
		}
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param xmlContent
	 *            the xml content
	 * @param contentType
	 *            the content type
	 * @param method
	 *            the method
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream requestMethod(String apiUrl, String contentType,
			String method, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();

			request.setConnectTimeout(getConnectionTimeout());
			request.setReadTimeout(getSocketTimeout());

			for (String headerName : requestHeaders.keySet()) {
				request.setRequestProperty(headerName,
						requestHeaders.get(headerName));
			}

			request.setRequestMethod(method);
			request.setDoOutput(true);

			if (contentType != null) {
				request.setRequestProperty("Content-Type", contentType);
			}

			request.connect();

			if (request.getResponseCode() != expected) {
				throw new UshahidiException(
						streamToString(getWrappedInputStream(
								request.getErrorStream(),
								GZIP_ENCODING.equalsIgnoreCase(request
										.getContentEncoding()))));
			} else {
				return getWrappedInputStream(request.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(request
								.getContentEncoding()));

			}
		} catch (IOException e) {
			throw new UshahidiException(e);
		}
	}

	/**
	 * Gets the wrapped input stream.
	 * 
	 * @param is
	 *            the is
	 * @param gzip
	 *            the gzip
	 * 
	 * @return the wrapped input stream
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected InputStream getWrappedInputStream(InputStream is, boolean gzip)
			throws IOException {
		if (gzip) {
			return new BufferedInputStream(new GZIPInputStream(is));
		} else {
			return new BufferedInputStream(is);
		}
	}

	/**
	 * Encode url.
	 * 
	 * @param original
	 *            the original
	 * 
	 * @return the string
	 */
	private static String encodeUrl(String original) {
		if (original == null) {
			return "";
		} else {
			try {
				return URLEncoder.encode(original, CHARSET_UTF8);
			} catch (UnsupportedEncodingException e) {
				// should never be here..
				return original;
			}
		}
	}

	/**
	 * Close stream.
	 * 
	 * @param is
	 *            the is
	 */
	protected void closeStream(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "An error occurred while closing stream.",
					e);
		}
	}

	/**
	 * Close connection.
	 * 
	 * @param connection
	 *            the connection
	 */
	protected void closeConnection(HttpURLConnection connection) {
		try {
			if (connection != null) {
				connection.disconnect();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE,
					"An error occurred while disconnecting connection.", e);
		}
	}
}
