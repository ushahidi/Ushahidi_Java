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
	 * 
	 * @param id
	 * @param title
	 * @param description
	 * @param color
	 * @param icon
	 */
	public CategoryFields(int id, String title, String description,
			String color, FileBody icon) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.color = color;
		this.icon = icon;
	}
}
