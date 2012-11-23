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
package com.ushahidi.java.sdk.api;

import com.ushahidi.java.sdk.annotations.Form;
import com.ushahidi.java.sdk.annotations.FormField;
import com.ushahidi.java.sdk.net.content.FileBody;

/**
 * Holds the form fields for submitting a category
 */
public class CategoryFields extends Form {

	/**
	 * The category ID
	 */
	@FormField(name = "category_id")
	private int id;

	/**
	 * The category's parent ID
	 */
	@FormField(name = "parent_id")
	private int parentId;

	/**
	 * Title of the category
	 */
	@FormField(name = "category_title")
	private String title;

	/**
	 * The description of the category
	 */
	@FormField(name = "category_description")
	private String description;

	/**
	 * The hexadecimal color code for the category
	 */
	@FormField(name = "category_color")
	private String color;

	/**
	 * The icon attached to the category
	 */
	@FormField(name = "category_image")
	private FileBody icon;

	/**
	 * The category for fields. Both the require and optional fields
	 * 
	 * @param id
	 *            The category ID
	 * @param parentId
	 *            The category's parent ID
	 * @param title
	 *            The category's ttile
	 * @param description
	 *            The category's description
	 * @param color
	 *            The hex color code. eg. 000000
	 * @param icon
	 *            The category icon
	 */
	public CategoryFields(int id, int parentId, String title,
			String description, String color, FileBody icon) {
		this.id = id;
		this.parentId = parentId;
		this.title = title;
		this.description = description;
		this.color = color;
		this.icon = icon;
	}

	/**
	 * The category for fields. These are all the required required minus the
	 * optional once
	 * 
	 * @param parentId
	 *            The category's parent ID
	 * @param title
	 *            The category's ttile
	 * @param description
	 *            The category's description
	 * @param color
	 *            The hex color code. eg. 000000
	 */
	public CategoryFields(int parentId, String title, String description,
			String color) {
		this(0, parentId, title, description, color, null);
	}

	/**
	 * The category for fields. These are all the required required minus the
	 * optional once
	 * 
	 * @param id
	 *            The category ID
	 * @param parentId
	 *            The category's parent ID
	 * @param title
	 *            The category's ttile
	 * @param description
	 *            The category's description
	 * @param color
	 *            The hex color code. eg. 000000
	 */
	public CategoryFields(int id, int parentId, String title,
			String description, String color) {
		this(id, parentId, title, description, color, null);
	}
}
