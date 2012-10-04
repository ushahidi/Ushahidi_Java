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

import com.ushahidi.java.sdk.net.HttpClient;

/**
 * This is the root of all API calls.
 * 
 * @author eyedol
 * 
 */
public class UshahidiAPI {

	// URL for the ushahidi deployment
	private String url;

	private int timeout;

	private UshahidiAPI(String url, int timeout) {
		this.url = url;
		this.timeout = timeout;
	}

	public static void main(String args[]) {
		System.out.println("making a get request");
		HttpClient httpClient = new HttpClient();
		final int status = httpClient.getAllReportFromWeb();
		System.out.println("HTTPClient Status: " + status);
	}

}
