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

import com.ushahidi.java.sdk.UshahidiApi;
import com.ushahidi.java.sdk.api.Category;
import com.ushahidi.java.sdk.api.Comment;
import com.ushahidi.java.sdk.api.json.Reports;
import com.ushahidi.java.sdk.api.tasks.IncidentsTask;
import com.ushahidi.java.sdk.net.PasswordAuthentication;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * An example implementation to show how to fetch all reports / incidents API
 * call -- api?task=incidents
 */
public class Incidents {

	public static void main(String args[]) {
		UshahidiApi ushahidi = new UshahidiApi("http://demo.ushahidi.com");
		ushahidi.factory.client = new UshahidiHttpClient();
		ushahidi.factory.client.setAuthentication(new PasswordAuthentication(
				"admin", "admin"));

		// create incidents task
		IncidentsTask task = ushahidi.factory.createIncidentsTask();

		// fetch all incidents / reports
		List<Reports.Payload.Incidents> incidents = task.all();

		System.out.println("Fetching all reports/incidents...");

		// display the fetched categories
		for (Reports.Payload.Incidents i : incidents) {
			System.out.println(i.incident);

			// get categories
			if ((i.getCategories() != null) && (!i.getCategories().isEmpty())) {
				System.out.println("Categories: ");
				for (Category c : i.getCategories()) {
					System.out.println(c);
				}
			}

			// get comments
			if ((i.getComments() != null) && (!i.getComments().isEmpty())) {
				System.out.println("Comments: ");
				for (Comment c : i.getComments()) {
					System.out.println(c);

				}
			}

			System.out.println();
		}
	}
}
