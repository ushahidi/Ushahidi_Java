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

import java.io.IOException;

import org.json.JSONException;

import com.ushahidi.java.sdk.api.tasks.CategoriesTask;
import com.ushahidi.java.sdk.api.tasks.UshahidiApiTaskFactory;

/**
 * This is the root of all API calls.
 * 
 * @author eyedol
 * 
 */
public class UshahidiApi {

	// URL for the ushahidi deployment
	public UshahidiApiTaskFactory taskFactory;

	public CategoriesTask categoriesTask;

	private UshahidiApi(String url) {
		taskFactory = UshahidiApiTaskFactory.newInstance(url);
		categoriesTask = taskFactory.categories();
	}

	public static void main(String args[]) {
		System.out.println("making a get request");
		String url = "https://syrianspring.crowdmap.com";
		UshahidiApi ushahidiApi = new UshahidiApi(url);
		try {
			ushahidiApi.categoriesTask.all();
			System.out.println(ushahidiApi.categoriesTask.all().get(0).getTitle());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
