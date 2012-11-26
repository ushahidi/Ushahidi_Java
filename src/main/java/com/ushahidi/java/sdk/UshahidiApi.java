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

import com.ushahidi.java.sdk.api.tasks.UshahidiApiTaskFactory;

/**
 * This is the root of all API calls.
 * 
 * @author eyedol
 * 
 */
public class UshahidiApi {

	/** A factory object for creating the various Ushahidi API tasks */

	private String version = "1.0";

	public UshahidiApiTaskFactory factory;

	public UshahidiApi(String url) {
		factory = UshahidiApiTaskFactory.newInstance(url);
	}

	public String getVersion() {
		return version;
	}
}
