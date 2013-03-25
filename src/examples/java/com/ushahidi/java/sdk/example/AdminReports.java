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
package com.ushahidi.java.sdk.example;

import java.util.List;

import com.ushahidi.java.sdk.api.tasks.ReportsAdminTask;

/**
 * 
 */
public class AdminReports extends Ushahidi {

	private ReportsAdminTask atask;

	public AdminReports() {
		super();
		atask = factory.createReportsAdminTask();
	}

	/**
	 * Fetch all verified reports
	 */
	public void getVerifiedReport() {
		List<com.ushahidi.java.sdk.api.Incidents> incidents = atask.verified();
		displayReports(incidents);
	}

}
