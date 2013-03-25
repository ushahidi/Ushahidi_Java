/**
 ** Copyright (c) 2010 Ushahidi Inc
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
 **/
package com.ushahidi.java.sdk.example;

import java.util.List;

import com.ushahidi.java.sdk.api.Category;
import com.ushahidi.java.sdk.api.Comment;
import com.ushahidi.java.sdk.api.Media;
import com.ushahidi.java.sdk.api.tasks.UshahidiApiTaskFactory;
import com.ushahidi.java.sdk.net.PasswordAuthentication;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;
import com.ushahidi.java.sdk.api.Incidents;

/**
 * The gateway to the Ushahidi API
 * 
 * @author eyedol
 * 
 */
public abstract class Ushahidi {

	protected UshahidiApiTaskFactory factory;

	public int connectionTimeout = 30000;

	public int socketTimeout = 30000;

	public Ushahidi() {
		factory = UshahidiApiTaskFactory
				.newInstance("http://demo.ushahidi.com");
		factory.client = new UshahidiHttpClient();
		factory.client.setAuthentication(new PasswordAuthentication("admin",
				"admin"));
		factory.client.setConnectionTimeout(connectionTimeout);
		factory.client.setSocketTimeout(socketTimeout);
	}

	protected void displayReports(List<Incidents> incidents) {
		// display the fetched categories
		if (incidents != null) {
			for (Incidents i : incidents) {
				System.out.println(i.incident);

				// get categories
				if ((i.getCategories() != null)
						&& (i.getCategories().size() > 0)) {
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

				// get media
				if ((i.getMedia() != null) && (!i.getMedia().isEmpty())) {
					System.out.println("Media: ");
					for (Media m : i.getMedia()) {
						System.out.println(m);
					}
				}

				System.out.println();
			}
		}
	}
}
