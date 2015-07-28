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

import com.google.gson.annotations.SerializedName;

/**
 * @author eyedol
 * 
 */
public class Category {

	/**
	 * The category ID
	 */
	private int id;

	/**
	 * Title of the category
	 */
	private String title;

	/**
	 * The description of the category
	 */
	private String description;

	/**
	 * The hexadecimal color code for the category
	 */
	private String color;

	/**
	 * The icon attached to the category
	 */
	private String icon;

	/**
	 * The position of the category
	 */
	private int position;

	/**
	 * The parent category
	 */
	@SerializedName("parent_id")
	private int parentId;

	/**
	 * Get the title of the category
	 * 
	 * @return The title of the category
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of the category
	 * 
	 * @param title
	 *            The title to be set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the description of the category
	 * 
	 * @return The description of the category
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the category
	 * 
	 * @param description
	 *            The description of the category
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the color of the category
	 * 
	 * @return The color of the category
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set the color of the category
	 * 
	 * @param color
	 *            The hex color code of the category
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Get the position of the category
	 * 
	 * @return The position of the category
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Set the position of the category
	 * 
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Set the parent ID of the category
	 * 
	 * @param parentId
	 *            The parent ID
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * Get the parent ID for the category
	 * 
	 * @return The parent ID
	 */
	public int getParentId() {
		return this.parentId;
	}

	/**
	 * Set the ID of the category
	 * 
	 * @param id
	 *            The ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the ID of the category
	 * 
	 * @return The ID
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Set the icon of the category
	 * 
	 * @param icon
	 *            The icon of the category
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * Get the icon attached to the category
	 * 
	 * @return The icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * Override toString method
	 */
	@Override
	public String toString() {
		return "Category [id:" + id + ", title:" + title + ", description:"
				+ description + ", color:" + color + ", icon:" + icon
				+ ", position:" + position + ", parentId:" + parentId + "]";
	}
}
