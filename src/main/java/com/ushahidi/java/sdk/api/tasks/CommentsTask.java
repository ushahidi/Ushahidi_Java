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
import com.ushahidi.java.sdk.api.CommentFields;
import com.ushahidi.java.sdk.api.json.Comments;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;
import com.ushahidi.java.sdk.net.content.Body;

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

	private static final String TASK = "comments";

	public Comments comments;

	public CommentsTask(String url) {
		super(url, TASK);
	}

	public CommentsTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
	}

	/**
	 * Get all comments.
	 * 
	 * @return The fetched comments
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Comment> all() {

		client.setRequestParameters("by", "all");
		// fetch all comments
		comments = fromString(client.sendGetRequest(url), Comments.class);
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

		client.setRequestParameters("by", "reportid");
		client.setRequestParameters("id", String.valueOf(id));
		// fetch all comment
		// fetch all categories
		comments = fromString(client.sendGetRequest(url), Comments.class);
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

		client.setRequestParameters("by", "spam");
		// fetch all categories
		comments = fromString(client.sendGetRequest(url), Comments.class);
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

		client.setRequestParameters("by", "pending");
		// fetch all categories
		comments = fromString(client.sendGetRequest(url), Comments.class);
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

		client.setRequestParameters("by", "approved");
		// fetch all categories
		comments = fromString(client.sendGetRequest(url), Comments.class);
		return comments.getComments();
	}

	/**
	 * Submit a new comment to an existing report
	 * 
	 * @return The response received from the server
	 */
	public Response submit(CommentFields comment) {
		client.setRequestParameters("action", "add");
		Body body = comment.getParameters(comment);
		return fromString(client.sendPostRequest(url, body), Response.class);
	}
}
