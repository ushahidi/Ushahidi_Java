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

import com.ushahidi.java.sdk.api.Comment;
import com.ushahidi.java.sdk.api.json.Comments;

/**
 * Implements all tasks related to comments.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Comments"
 * >Ushahidi Public API</a> for more details
 * 
 * @author eyedol
 * 
 */
public class CommentsTask extends BaseTask {

	public CommentsTask(String url) {
		super(url);
	}

	/**
	 * Get all comments.
	 * 
	 * @return The fetched comments
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Comment> all() {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=comments");
		uriBuilder.append("&by=all");
		uriBuilder.append("&resp=json");

		// fetch all comments
		Comments comments = fromString(
				client.sendGetRequest(uriBuilder.toString()), Comments.class);
		return comments.getComments();
	}

	/**
	 * Get all comments for a specific report.
	 * 
	 * @param id
	 *            The report id
	 * @return The comments associated to the specified report id
	 */
	public List<Comment> reportId(int id) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=comments");
		uriBuilder.append("&by=reportid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");

		// fetch all comment
		// fetch all categories
		Comments comments = fromString(
				client.sendGetRequest(uriBuilder.toString()), Comments.class);
		return comments.getComments();
	}

	/**
	 * Get all comment marked as spam. This Method requires authentication so
	 * make sure
	 * {@link #setAuthentication(com.ushahidi.java.sdk.net.Authentication)} is
	 * set before calling this method.
	 * 
	 * @return The spam comments
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Comment> spam() {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=comments");
		uriBuilder.append("&by=spam");
		uriBuilder.append("&resp=json");
		// fetch all categories
		Comments comments = fromString(
				client.sendGetRequest(uriBuilder.toString()), Comments.class);
		return comments.getComments();

	}

	/**
	 * Get all pending comments. This Method requires authentication so make
	 * sure {@link #setAuthentication(com.ushahidi.java.sdk.net.Authentication)}
	 * is set.
	 * 
	 * @return The pending comment
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Comment> pending() {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=comments");
		uriBuilder.append("&by=pending");
		uriBuilder.append("&resp=json");

		// fetch all categories
		Comments comments = fromString(
				client.sendGetRequest(uriBuilder.toString()), Comments.class);
		return comments.getComments();

	}

	/**
	 * Get all approved comments. This Method requires authentication so make
	 * sure {@link #setAuthentication(com.ushahidi.java.sdk.net.Authentication)}
	 * is set.
	 * 
	 * @return The approved comments
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Comment> approved() {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=comments");
		uriBuilder.append("&by=approved");
		uriBuilder.append("&resp=json");
		// fetch all categories
		Comments comments = fromString(
				client.sendGetRequest(uriBuilder.toString()), Comments.class);
		return comments.getComments();
	}

}
