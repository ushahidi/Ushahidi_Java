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
import com.ushahidi.java.sdk.UshahidiException;
import com.ushahidi.java.sdk.api.Comment;

/**
 * Implements all tasks related to comments.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Comments"
 * >Ushahidi Public API for Comments</a> for more details
 * 
 * @author eyedol
 * 
 */
public class CommentsTask extends Payload<Comment> {

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

		// fetch all categories
		return process(client.sendGetRequest(uriBuilder.toString()));

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
		return getComments(uriBuilder.toString());
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
		return process(client.sendGetRequest(uriBuilder.toString()));

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
		return getComments(uriBuilder.toString());

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
		return getComments(uriBuilder.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ushahidi.java.sdk.Payload#processModels()
	 */
	@Override
	public List<Comment> processModels() {
		List<Comment> listcomment = new ArrayList<Comment>();
		try {
			if (!getPayloadObj().isNull("comments")) {
				JSONArray commentsArr = getPayloadObj()
						.getJSONArray("comments");
				int id = 0;
				if (commentsArr != null) {

					for (int i = 0; i < commentsArr.length(); i++) {
						Comment comment = new Comment();

						id = commentsArr.getJSONObject(i)
								.getJSONObject("comment").getInt("id");
						comment.setId(id);

						if (!commentsArr.getJSONObject(i)
								.getJSONObject("comment").isNull("incident_id")) {
							comment.setReportId(commentsArr.getJSONObject(i)
									.getJSONObject("comment")
									.getInt("incident_id"));
						}

						if (!commentsArr.getJSONObject(i)
								.getJSONObject("comment")
								.isNull("comment_description")) {
							comment.setDescription(commentsArr.getJSONObject(i)
									.getJSONObject("comment")
									.getString("comment_description"));
						}

						if (!commentsArr.getJSONObject(i)
								.getJSONObject("comment")
								.isNull("comment_author")) {

							comment.setAuthor(commentsArr.getJSONObject(i)
									.getJSONObject("comment")
									.getString("comment_author"));
						}

						if (!commentsArr.getJSONObject(i)
								.getJSONObject("comment")
								.isNull("comment_date")) {
							comment.setDate(commentsArr.getJSONObject(i)
									.getJSONObject("comment")
									.getString("comment_date"));
						}

						listcomment.add(comment);
					}
					return listcomment;
				}
			}

		} catch (JSONException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public List<Comment> processModel() {
		// only one comment was returned
		List<Comment> listcomment = new ArrayList<Comment>();
		Comment comment = new Comment();

		try {

			if (getPayloadObj().getJSONObject("comments").isNull("id")) {
				comment.setId(getPayloadObj().getJSONObject("comments").getInt(
						"id"));
			}

			if (!getPayloadObj().getJSONObject("comments")
					.isNull("incident_id")) {
				comment.setReportId(getPayloadObj().getJSONObject("comments")
						.getInt("incident_id"));
			}

			if (!getPayloadObj().getJSONObject("comments").isNull(
					"comment_description")) {
				comment.setDescription(getPayloadObj()
						.getJSONObject("comments").getString(
								"comment_description"));
			}

			if (!getPayloadObj().getJSONObject("comments").isNull(
					"comment_author")) {

				comment.setAuthor(getPayloadObj().getJSONObject("comments")
						.getString("comment_author"));
			}

			if (!getPayloadObj().getJSONObject("comments").isNull(
					"comment_date")) {
				comment.setDate(getPayloadObj().getJSONObject("comments")
						.getString("comment_date"));
			}

			listcomment.add(comment);
		} catch (JSONException e) {
			throw new UshahidiException(e.getCause());
		}
		return listcomment;
	}

	private List<Comment> getComments(String url) {
		try {
			return processPayload(client.sendGetRequest(url));
		} catch (JSONException e) {
			throw new UshahidiException(e.getCause());
		} catch (IOException e) {
			throw new UshahidiException(e.getCause());
		}
	}

	private List<Comment> processPayload(String jsonString)
			throws JSONException, IOException {
		setJsonObject(jsonString);
		if (getJsonObject() != null) {
			if (!getPayloadObj().isNull("domain")) {
				setDomain(getPayloadObj().getString("domain"));
			}
			if (!getJsonObject().isNull("error")) {
				setCode(getJsonObject().getJSONObject("error").getInt("code"));
				setMessage(getJsonObject().getJSONObject("error").getString(
						"message"));
			}
			return processModels();
		}
		return null;
	}

	private List<Comment> process(String jsonString) {
		try {
			setJsonObject(jsonString);

			if (getJsonObject() != null) {
				if (!getPayloadObj().isNull("domain")) {
					setDomain(getPayloadObj().getString("domain"));
				}
				if (!getJsonObject().isNull("error")) {
					setCode(getJsonObject().getJSONObject("error").getInt(
							"code"));
					setMessage(getJsonObject().getJSONObject("error")
							.getString("message"));
				}
				return processModel();
			}
		} catch (JSONException e) {
			throw new UshahidiException(e.getCause());
		}
		return null;
	}

}
