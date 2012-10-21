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
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.ushahidi.java.sdk.Payload;
import com.ushahidi.java.sdk.api.Category;

/**
 * Implements all tasks related to Categories.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Categories"
 * >Ushahidi Public API for Categories</a> for more details
 * 
 * @author eyedol
 * 
 */
public class CategoriesTask extends Payload<Category> {

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
	public List<Category> all() throws JSONException, IOException {

		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=categories");
		uriBuilder.append("&resp=json");

		// fetch all categories
		return getCategories(uriBuilder.toString());

	}

	/**
	 * Get a visible category by it's ID.
	 * 
	 * @param id
	 *            The category's ID
	 * @return The fetched category
	 */
	public Category catId(int id) throws JSONException, IOException {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=categories");
		uriBuilder.append("&by=catid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");
		List<Category> categories = getCategories(uriBuilder.toString());
		if (categories != null && categories.size() > 0) {
			return categories.get(0);
		}
		return null;
	}

	private List<Category> getCategories(String url) throws JSONException,
			IOException {
		return processPayload(client.sendGetRequest(url));
	}

	private List<Category> processPayload(String jsonString)
			throws JSONException, IOException {
		setJsonObject(jsonString);
		if (getJsonObject() != null) {
			setDomain(getPayloadObj().getString("domain"));
			setCode(getJsonObject().getJSONObject("error").getInt("code"));
			setMessage(getJsonObject().getJSONObject("error").getString(
					"message"));
			return processModels();
		}
		return null;
	}

	/**
	 * Process the JSON data to get the data associated with the categories
	 * 
	 * @see com.ushahidi.java.sdk.Payload#processModels()
	 * 
	 * 
	 * @throws JSONException
	 */
	@Override
	public List<Category> processModels() {
		List<Category> listCategory = new ArrayList<Category>();
		try {
			if (!getPayloadObj().isNull("categories")) {
				JSONArray categoriesArr = getPayloadObj().getJSONArray(
						"categories");
				int id = 0;
				if (categoriesArr != null) {

					for (int i = 0; i < categoriesArr.length(); i++) {
						Category category = new Category();

						id = categoriesArr.getJSONObject(i)
								.getJSONObject("category").getInt("id");
						category.setId(id);
						if (!categoriesArr.getJSONObject(i)
								.getJSONObject("category").isNull("color")) {
							category.setColor(categoriesArr.getJSONObject(i)
									.getJSONObject("category")
									.getString("color"));
						}

						if (!categoriesArr.getJSONObject(i)
								.getJSONObject("category").isNull("parent_id")) {
							category.setParentId(categoriesArr.getJSONObject(i)
									.getJSONObject("category")
									.getInt("parent_id"));
						}

						if (!categoriesArr.getJSONObject(i)
								.getJSONObject("category")
								.isNull("description")) {
							category.setDescription(categoriesArr
									.getJSONObject(i).getJSONObject("category")
									.getString("description"));
						}

						if (!categoriesArr.getJSONObject(i)
								.getJSONObject("category").isNull("title")) {

							category.setTitle(categoriesArr.getJSONObject(i)
									.getJSONObject("category")
									.getString("title"));
						}

						if (!categoriesArr.getJSONObject(i)
								.getJSONObject("category").isNull("position")) {
							category.setPosition(categoriesArr.getJSONObject(i)
									.getJSONObject("category")
									.getInt("position"));
						}

						listCategory.add(category);
					}
					return listCategory;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
