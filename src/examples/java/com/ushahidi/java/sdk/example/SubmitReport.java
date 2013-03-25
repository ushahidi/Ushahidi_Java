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

import java.io.File;
import java.util.Date;

import com.ushahidi.java.sdk.api.Incident;
import com.ushahidi.java.sdk.api.ReportFields;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.api.tasks.ReportTask;

/**
 * 
 */
public class SubmitReport extends Ushahidi {

	private ReportTask task;

	public SubmitReport() {
		task = factory.createReportTask();
	}

	/**
	 * Submit a report
	 */
	public void submitReport() {
		Incident i = new Incident();
		i.setTitle("Test title");
		i.setDescription("Test desc");
		i.setDate(new Date());
		i.setLatitude(12.34);
		i.setLongitude(56.78);
		i.setLocationName("foobar");

		ReportFields fields = new ReportFields();
		fields.fill(i);
		// add categories
		fields.addCategory(7);
		// add photos
		fields.addPhotos(new File("/sdcard/nophoto.jpg"));

		Response response = task.submit(fields);

		// print response from server
		System.out.println("Error: " + response.getErrorCode() + " Message: "
				+ response.getErrorMessage());

	}
}
