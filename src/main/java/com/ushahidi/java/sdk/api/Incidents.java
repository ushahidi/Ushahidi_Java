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

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Incidents {

	public Incident incident;

	public static class _Categories {
		public Category category;
	}

	public static class _Comment {
		public Comment comment;
	}

	private List<Media> media;

	private List<Incidents._Comment> comments;

	private List<Incidents._Categories> categories;

	/**
	 * Get comments
	 * 
	 * @return The list of comments
	 */
	public List<Comment> getComments() {
		ArrayList<Comment> ret = new ArrayList<Comment>();
		for (_Comment c : comments) {
			ret.add(c.comment);
		}
		return ret;
	}

	/**
	 * Get media
	 */
	public List<Media> getMedia() {
		return media;
	}

	/**
	 * Get categories
	 * 
	 * @return The list of categories
	 */
	public List<Category> getCategories() {
		ArrayList<Category> ret = new ArrayList<Category>();
		for (_Categories c : categories) {
			ret.add(c.category);
		}
		return ret;
	}

}