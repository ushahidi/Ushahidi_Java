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

import java.io.IOException;
import java.util.List;

import com.ushahidi.java.sdk.api.Category;
import com.ushahidi.java.sdk.api.CategoryFields;
import com.ushahidi.java.sdk.api.json.Categories;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.content.Body;

/**
 * Implements all tasks related to Categories.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Categories"
 * >Ushahidi Public API </a> for more details
 * 
 * @author eyedol
 * 
 */
public class CategoriesTask extends BaseTask {

	private static final String TASK = "categories";

	/**
	 * Create the Categories task
	 * 
	 * @param url
	 *            The URL of the Ushahidi deployment
	 */
	public CategoriesTask(String url) {
		super(url, TASK);
	}

	/**
	 * Gets all visible categories submitted to the Ushahidi deployment.
	 * 
	 * 
	 * @return The fetched categories
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Category> all() {

		final Categories categories = fromString(client.sendGetRequest(url),
				Categories.class);
		return categories.getCategories();
	}

	/**
	 * Get a visible category by it's ID.
	 * 
	 * @param id
	 *            The category's ID
	 * @return The fetched category
	 */
	public Category catId(int id) {

		client.setRequestParameters("by", "catid");
		client.setRequestParameters("id", String.valueOf(id));
		final Categories categories = fromString(client.sendGetRequest(url),
				Categories.class);
		return categories.getCategory();
	}

	private Body adminBody(int id, String action, Body body) {
		body.addField("task", "category");
		body.addField("action", action);
		body.addField("category_id", String.valueOf(id));
		return body;
	}

	private Response admin(int id, String action) {
		Body body = adminBody(id, action, new Body());
		return fromString(this.client.sendPostRequest(url, body),
				Response.class);
	}

	/**
	 * Make a multipart post request
	 * 
	 * @param body
	 *            The fields to be submitted
	 * @return
	 */
	private Response admin(Body body) {
		return fromString(client.sendMultipartPostRequest(url, body),
				Response.class);
	}

	/**
	 * Add a new category to the Ushahidi deployment. This method requires
	 * authentication. Set {@link #setAuthentication(String, String)} or set
	 * {@link #getClient().setAuthentication()}
	 * 
	 * @param fields
	 *            CategoryFields
	 * @return response
	 */
	public Response add(CategoryFields fields) {

		Body body = fields.getParameters(fields);
		body.addField("action", "add");
		return admin(body);
	}

	/**
	 * Edit an existing category. Requires authentication
	 * 
	 * @param fields
	 * @return
	 */
	public Response edit(CategoryFields fields) {
		Body body = fields.getParameters(fields);
		body.addField("action", "edit");
		return admin(body);
	}

	/**
	 * Delete an existing category in the Ushahidi deployment. This method
	 * requires authentication. Perhaps set
	 * {@link #setAuthentication(String, String)} or set {@link #getClient()
	 * .setAuthentication()}
	 * 
	 * @param id
	 *            Category ID
	 * @return
	 */
	public Response delete(int id) {
		return admin(id, "delete");
	}

}
