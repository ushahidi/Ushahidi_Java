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

import com.ushahidi.java.sdk.UshahidiException;
import com.ushahidi.java.sdk.api.tasks.IncidentsTask;

/**
 * An example implementation to show how to fetch all reports / incidents API
 * call -- api?task=incidents
 */
public class Incidents extends Ushahidi {

	IncidentsTask task;

	public Incidents() {
		task = factory.createIncidentsTask();
	}

	public void fetchAllReports() {
		// fetch all incidents / reports
		try {
			List<com.ushahidi.java.sdk.api.Incidents> incidents = task.all();

			System.out.println("Fetching all reports/incidents...");

			displayReports(incidents);
		} catch (UshahidiException e) {
			//System.out.println(e.getMessage());
		}

	}

}
