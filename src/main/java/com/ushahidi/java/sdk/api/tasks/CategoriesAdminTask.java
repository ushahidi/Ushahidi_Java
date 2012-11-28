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

import com.ushahidi.java.sdk.api.CategoryFields;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * Administrative tasks on categories
 */
public class CategoriesAdminTask extends BaseTask {

	private static final String TASK = "category";

	/**
	 * This requires authentication
	 * 
	 * @param url
	 */
	public CategoriesAdminTask(String url) {
		super(url, TASK);
	}

	public CategoriesAdminTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
	}

	/**
	 * Add a new category to the Ushahidi deployment. This method requires
	 * authentication. Perhaps set {@link #setAuthentication(String, String)} or
	 * set {@link #setAuthentication(com.ushahidi.java.sdk.net.Authentication)}
	 * 
	 * @param fields
	 *            CategoryFields
	 * @return response
	 */
	public Response add(CategoryFields fields) {
		client.setRequestParameters("action", "add");
		return fromString(
				client.sendMultipartPostRequest(url,
						fields.getParameters(fields)), Response.class);
	}

	/**
	 * Edit an existing category. Requires authentication
	 * 
	 * @param fields
	 * @return The response received from the server
	 */
	public Response edit(CategoryFields fields) {
		client.setRequestParameters("action", "edit");
		return fromString(
				client.sendMultipartPostRequest(url,
						fields.getParameters(fields)), Response.class);
	}

	/**
	 * Delete an existing category in the Ushahidi deployment.
	 * 
	 * @param id
	 *            Report ID
	 * @return The response received from the server
	 */
	public Response delete(int id) {
		client.setRequestParameters("action", "delete");
		client.setRequestParameters("category_id", String.valueOf(id));
		return fromString(client.sendPostRequest(url), Response.class);
	}

}
