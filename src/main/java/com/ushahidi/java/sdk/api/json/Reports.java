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
import com.ushahidi.java.sdk.api.Comment;
import com.ushahidi.java.sdk.api.Incident;
import com.ushahidi.java.sdk.api.Media;

/**
 * @author eyedol
 * 
 */
public class Reports extends Response {

	public static class Payload extends Response.Payload {

		public static class Incidents {

			public static class _Incident {
				public Incident report;
			}

			public static class _Categories {
				public Category category;
			}

			public static class _Comment {
				public Comment comment;
			}

			public static class _Media {
				public Media m;
			}

			public Incident incident;

			public List<Incidents._Categories> categories;

			public List<Incidents._Media> media;

			public List<Incidents._Comment> comments;

			/**
			 * Get categories
			 * 
			 * @return
			 */
			public List<Category> getCategories() {
				ArrayList<Category> ret = new ArrayList<Category>();
				for (_Categories c : categories) {
					ret.add(c.category);
				}
				return ret;
			}

			/**
			 * Get comments
			 * 
			 * @return
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
				ArrayList<Media> ret = new ArrayList<Media>();
				for (_Media med : media) {
					ret.add(med.m);
				}
				return ret;
			}

		}

		public List<Incidents> incidents;

	}

	private Payload payload;

	public Reports getReport() {
		return this;
	}

	public Payload getPayload() {
		return payload;
	}
}
