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

import java.util.HashMap;
import java.util.Map;

import com.ushahidi.java.sdk.util.Base64;

/**
 * This class handles HTTP header base Authentication mechanism
 * 
 * @author eyedol
 * 
 */
public class PasswordAuthentication implements HeaderAuthentication {

	/** The Constant BASIC. */
	private static final String BASIC = "Basic ";
	
	private static final String HEADER_AUTHORIZATION = "Authorization";

	/** The login. */
	public String login;

	/** The password. */
	public String password;

	/**
	 * Instantiates a new login password authentication.
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 */
	public PasswordAuthentication(String login, String password) {
		this.login = login;
		this.password = password;
	}

	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
    	String credentials = login + ":" + password;
    	headers.put(HEADER_AUTHORIZATION, BASIC + Base64.encodeBytes(credentials.getBytes()));
    	return headers;
	}
}
