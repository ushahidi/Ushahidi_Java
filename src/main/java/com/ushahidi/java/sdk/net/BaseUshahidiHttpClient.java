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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.ushahidi.java.sdk.UshahidiException;
import com.ushahidi.java.sdk.net.content.Body;
import com.ushahidi.java.sdk.net.content.Field;
import com.ushahidi.java.sdk.net.content.FileBody;

/**
 * This is a custom implementation of an HTTP client based on the existing
 * classes provided by the standard java.net package.
 * <p>
 * It implements both POST and GET requests. In addition it supports multi-part
 * POST request to allow file uploads.
 * </p>
 * 
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

	private static final String POST_METHOD = "POST";

	private static final String GET_METHOD = "GET";

	/** The request headers. */
	protected Map<String, String> requestHeaders = new HashMap<String, String>();

	/** The request parameters. */
	protected Map<String, String> requestParameters = new HashMap<String, String>();

	/** The charset encoding type */
	private static final String CHARSET_UTF8 = "UTF-8";

	/** The default time to timeout both connection and socket reads */
	private static final int TIMEOUT = 3000;

	/**
	 * The default connection timeout is 3 secs. You can override this value by
	 * calling the {@link BaseUshahidiHttpClient#setConnectionTimeout(int)}.
	 */
	private int connectionTimeout = 0;

	/**
	 * The default socket timeout is 3 secs. You can override this value by
	 * calling the {@link BaseUshahidiHttpClient#setSocketTimeout(int)}
	 */
	private int socketTimeout = 0;

	private int bufferSize = 8192;

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
	 * Get request paramenters
	 * 
	 * @return
	 */
	public Map<String, String> getRequestParameters() {
		return requestParameters;
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
	 * @param connectionTimeout
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
		if (connectionTimeout > 0) {
			return this.connectionTimeout;
		}
		return TIMEOUT;

	}

	/**
	 * Set the default socket timeout. The default socket timeout is 3 secs.
	 * 
	 * @param socketTimeout
	 *            An <code>int</code> that specifies the socket timeout value in
	 *            milliseconds
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
	 * @return The socket timeout in milliseconds
	 */
	public int getSocketTimeout() {
		if (socketTimeout > 0) {
			return this.socketTimeout;
		}
		return TIMEOUT;
	}

	/**
	 * Convert stream to string
	 * 
	 * @param is
	 *            the input stream to be converted to string
	 * 
	 * @return the converted string
	 */
	public String streamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader;
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(is, CHARSET_UTF8), bufferSize);
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
	 *            the API url
	 * 
	 * @return the input stream
	 */
	protected InputStream getRequest(String url) {
		return getRequest(url, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Make a POST request
	 * 
	 * @param url
	 *            The API URL
	 * @param body
	 *            The parameters to be passed to the URL
	 * @return The input stream
	 */
	protected InputStream postRequest(String url, Body body) {
		return postRequest(url, body, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Make a POST request
	 * 
	 * @param url
	 *            The API URL
	 * @return The input stream
	 */
	protected InputStream postRequest(String url) {
		return postRequest(url, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Make a Multi-part POST request. This request makes it possible to upload
	 * files.
	 * 
	 * @param url
	 *            The API URL
	 * @param body
	 *            The parameters to be passed to the URL
	 * 
	 * @return the input stream
	 */
	protected InputStream postMultipartRequest(String url, Body body) {
		return postMultipartRequest(url, body, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Make a GET request.
	 * 
	 * @param url
	 *            The API URL
	 * @param expected
	 *            The expected
	 * 
	 * @return The input stream
	 */
	protected InputStream getRequest(String url, int expected) {
		try {
			URL apiUrl = new URL(url);
			if (!requestParameters.isEmpty()) {
				if (apiUrl.getQuery() == null) {
					apiUrl = new URL(url + "?"
							+ getParametersString(requestParameters));
				} else {
					apiUrl = new URL(url + "&"
							+ getParametersString(requestParameters));
				}
			}

			HttpURLConnection request = openConnection(apiUrl, GET_METHOD);
			request.connect();
			
			// follow, 3xx is redirect
			int responseCode = request.getResponseCode();
			boolean redirect = false;
			if (responseCode != HttpURLConnection.HTTP_OK) {
				if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP
						|| responseCode == HttpURLConnection.HTTP_MOVED_PERM
						|| responseCode == HttpURLConnection.HTTP_SEE_OTHER)
					redirect = true;
			}

			if(redirect) {
				String location = request.getHeaderField("Location");
				request = openConnection(new URL(location), GET_METHOD);
				request.connect();
			}
			
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
	 *            The API URL
	 * @param body
	 *            The parameters
	 * @param expected
	 *            The expected
	 * 
	 * @return The input stream
	 */
	protected InputStream postRequest(String apiUrl, Body body, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = openConnection(url, POST_METHOD);
			StringBuilder builder = new StringBuilder();
			// for request header passed earlier on
			final String strParams = getParametersString(requestParameters);
			builder.append(strParams);
			// for request passed via body object
			// couldn't figure out a better way of doing this
			if (strParams.length() > 0) {
				builder.append("&");
			}
			builder.append(getBodyString(body));

			PrintStream out = new PrintStream(new BufferedOutputStream(
					request.getOutputStream()));

			out.print(builder.toString());
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
	 * Make a POST request.
	 * 
	 * @param apiUrl
	 *            The API URL
	 * 
	 * @param expected
	 *            The expected
	 * 
	 * @return The input stream
	 */
	protected InputStream postRequest(String apiUrl, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = openConnection(url, POST_METHOD);

			PrintStream out = new PrintStream(new BufferedOutputStream(
					request.getOutputStream()));

			out.print(getParametersString(requestParameters));
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
	public String getParametersString(Map<String, String> parameters) {
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
	 * Gets the Body string.
	 * 
	 * @param body
	 *            the parameters
	 * 
	 * @return the parameters string
	 */
	protected String getBodyString(Body body) {
		StringBuilder builder = new StringBuilder();
		for (Iterator<Field> iterator = body.getFields().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();
			builder.append(field.getName());
			builder.append("=");
			if (field.getValue() != null) {
				builder.append(encodeUrl(field.getValue().toString()));
			}
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
	 *            The API URL
	 * @param body
	 *            The parameters to be passed to the multipart request
	 * @param expected
	 *            The expected output
	 * 
	 * @return the input stream
	 */
	protected InputStream postMultipartRequest(String apiUrl, Body body,
			int expected) {
		try {

			URL url = new URL(apiUrl);
			HttpURLConnection request = openConnection(url, POST_METHOD);
			String boundary = "00content0boundary00";

			request.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + boundary);

			BufferedOutputStream output = new BufferedOutputStream(
					request.getOutputStream());
			byte[] boundarySeparator = ("--" + boundary + "\r\n")
					.getBytes(CHARSET_UTF8);
			byte[] newline = "\r\n".getBytes(CHARSET_UTF8);

			// process request parameters if we have them
			if (!requestParameters.isEmpty() && requestParameters != null) {
				for (Iterator<Map.Entry<String, String>> iterator = requestParameters
						.entrySet().iterator(); iterator.hasNext();) {

					Map.Entry<String, String> entry = iterator.next();

					output.write(boundarySeparator);
					StringBuilder partBuffer = new StringBuilder(
							"Content-Disposition: ");
					partBuffer.append("form-data; name=\"");
					partBuffer.append(entry.getKey());
					partBuffer.append('"');
					output.write(partBuffer.toString().getBytes(CHARSET_UTF8));
					output.write(newline);
					output.write(newline);

					output.write(entry.getValue().toString()
							.getBytes(CHARSET_UTF8));

					output.write(newline);

				}

			}

			// process field names
			try {
				for (Field field : body.getFields()) {
					output.write(boundarySeparator);
					final Object value = field.getValue();
					StringBuilder partBuffer = new StringBuilder(
							"Content-Disposition: ");
					partBuffer.append("form-data; name=\"");
					partBuffer.append(field.getName());
					partBuffer.append('"');
					if (value instanceof FileBody) {
						FileBody fileBody = (FileBody) value;
						partBuffer.append("; filename=\"")
								.append(fileBody.getFilename()).append('"');
					}
					output.write(partBuffer.toString().getBytes(CHARSET_UTF8));
					output.write(newline);
					output.write(newline);

					// Get file to be uploaded
					if (value instanceof FileBody) {
						FileBody fileBody = (FileBody) value;
						fileBody.writeTo(output);

					} else {
						// don't write null fields
						if (field.getValue() != null) {
							output.write(field.getValue().toString()
									.getBytes(CHARSET_UTF8));
						}
					}
					output.write(newline);
				}
				output.write(("--" + boundary + "--\r\n").getBytes(CHARSET_UTF8)); //$NON-NLS-1$ //$NON-NLS-2$
			} finally {
				output.close();
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
		} finally {
		}
	}

	/**
	 * A generic HTTP method
	 * 
	 * @param apiUrl
	 *            the API URL
	 * 
	 * @param contentType
	 *            The content type
	 * @param method
	 *            The HTTP method
	 * @param expected
	 *            The expected output
	 * 
	 * @return the input stream
	 */
	protected InputStream requestMethod(String apiUrl, String contentType,
			String method, int expected) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection request = openConnection(url, method);

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
	 * Sets the authentication.
	 * 
	 * @param authentication
	 *            the new authentication
	 */
	public void setAuthentication(Authentication authentication) {
		if (authentication != null) {
			if (authentication instanceof HeaderAuthentication) {
				requestHeaders.putAll(((HeaderAuthentication) authentication)
						.getHeaders());
			}
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
			return new BufferedInputStream(new GZIPInputStream(is), bufferSize);
		}
		return new BufferedInputStream(is, bufferSize);

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

	/**
	 * Helper method for creating a Proxy object
	 * 
	 * @param ip
	 *            ip address
	 * @param port
	 *            port number
	 * @return the created Proxy object
	 */
	public static Proxy createProxy(String ip, int port) {
		return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
	}

	private Proxy proxy;

	/**
	 * Set the proxy to use for HTTP requests
	 * 
	 * @param ip
	 *            ip address
	 * @param port
	 *            port number
	 */
	public void setProxy(String ip, int port) {
		setProxy(createProxy(ip, port));
	}

	/**
	 * Set the proxy to use for HTTP requests
	 * 
	 * @param p
	 */
	public void setProxy(Proxy p) {
		proxy = p;
	}

	/**
	 * Convinient method for openConnection(u, method, true)
	 * 
	 * @param u
	 * @param method
	 * @return
	 * @throws IOException
	 */
	private HttpURLConnection openConnection(URL u, String method)
			throws IOException {
		return openConnection(u, method, true);
	}

	/**
	 * create a HttpURLConnection with default parameters
	 * 
	 * @param u
	 *            url
	 * @param method
	 *            request method ("GET"/"POST")
	 * @param doOutput
	 *            passed to HttpURLConnection.doOutput()
	 * @return the created HttpURLConnection
	 * @throws IOException
	 */
	private HttpURLConnection openConnection(URL u, String method,
			boolean doOutput) throws IOException {
		URLConnection ret = proxy == null ? u.openConnection() : u
				.openConnection(proxy);
		HttpURLConnection request = (HttpURLConnection) ret;

		request.setConnectTimeout(getConnectionTimeout());
		request.setReadTimeout(getSocketTimeout());

		for (String headerName : requestHeaders.keySet()) {
			request.setRequestProperty(headerName,
					requestHeaders.get(headerName));
		}
		if (method == POST_METHOD)
			request.setDoOutput(doOutput);
		request.setRequestMethod(method);
		return request;
	}
}
