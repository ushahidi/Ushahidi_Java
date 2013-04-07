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
package com.ushahidi.java.sdk.api.json;

import java.util.ArrayList;
import java.util.List;

import com.ushahidi.java.sdk.api.Category;

/**
 * The Category class has all the properties and methods of the Ushahidi API's
 * category resource
 * 
 * @author eyedol
 * 
 */
public class Categories extends Response {

	private static class Payload extends Response.Payload {

		private static class _Category {
			private Category category;
		}

		private List<_Category> categories;

		private Category category;

	}

	private Payload payload;

	/**
	 * Get list of categories
	 * 
	 * @return The list of categories otherwise null
	 */
	public List<Category> getCategories() {

		List<Category> cat = new ArrayList<Category>();
		if (payload != null) {
			// check if There are no results to show.
			if (!error.code.equals("007")) {
				for (Payload._Category c : payload.categories) {
					Category category = c.category;
					cat.add(category);
				}
			}
		}
		return cat;

	}

	/**
	 * Get a particular category
	 * 
	 * @return The category else return null
	 */
	public Category getCategory() {
		if (payload != null) {
			return payload.category;
		}
		return null;
	}
}
