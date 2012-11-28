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

import com.ushahidi.java.sdk.api.json.System;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * The system info task
 * 
 * @author eyedol
 * 
 */
public class SystemTask extends BaseTask {

	private static final String TASK = "version";

	/**
	 * Default constructor
	 * 
	 * @param url
	 *            The Ushahidi deployment
	 */
	public SystemTask(String url) {
		super(url, TASK);
	}

	/**
	 * You can pass a configured UshahidiHttpClient
	 * 
	 * @param url
	 *            The Ushahidi deployment URL
	 * @param client
	 *            The ushahidi HTTP client
	 */
	public SystemTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
	}

	/**
	 * Get the version task API call
	 * 
	 * @return The {@link com.ushahidi.java.sdk.api.json.System}
	 */
	public System fetch() {

		return fromString(client.sendGetRequest(url), System.class);
	}
}
