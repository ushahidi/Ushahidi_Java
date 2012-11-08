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

import org.json.JSONException;

import com.ushahidi.java.sdk.api.Categories;
import com.ushahidi.java.sdk.api.Category;

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

	/**
	 * Create the Categories task
	 */
	public CategoriesTask(String url) {
		super(url);
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

		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=categories");
		uriBuilder.append("&resp=json");

		final Categories categories = fromString(
				client.sendGetRequest(uriBuilder.toString()), Categories.class);
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
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=categories");
		uriBuilder.append("&by=catid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");
		final Categories categories = fromString(
				client.sendGetRequest(uriBuilder.toString()), Categories.class);
		return categories.getCategory();
	}

}
