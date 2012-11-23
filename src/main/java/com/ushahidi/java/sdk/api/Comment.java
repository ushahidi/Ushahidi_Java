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
import com.ushahidi.java.sdk.api.json.Date;

/**
 * This Comment class has all properties and methods of the Ushahidi API's
 * comment resource
 * 
 * @author eyedol
 * 
 */
public class Comment {

	/**
	 * The unique ID for the comment
	 */
	@SerializedName("id")
	private int id;

	/**
	 * The unique ID of a checking
	 */
	@SerializedName("checkin_id")
	private int checkinId;

	/**
	 * The unique ID of a report
	 */
	@SerializedName("incident_id")
	private int reportId;

	/**
	 * The name of the person who submitted the comment
	 */
	@SerializedName("comment_author")
	private String author;

	/**
	 * The description of the comment. This in fact the actual comment passed
	 */
	@SerializedName("comment_description")
	private String description;

	/**
	 * The date the comment was submitted.
	 */
	@SerializedName("comment_date")
	private Date date;

	/**
	 * The email address of the author
	 */
	@SerializedName("comment_email")
	private String email;

	/**
	 * The IP address that posted the comment
	 */
	@SerializedName("comment_ip")
	private String ip;

	/**
	 * The spam status of the comment
	 */
	@SerializedName("comment_spam")
	private int spam;

	/**
	 * The activness of the comment
	 */
	@SerializedName("comment_active")
	private int active;

	@SerializedName("comment_date_gmt")
	private String gmt;

	/**
	 * The ID of the user
	 */
	@SerializedName("user_id")
	private int userId;

	/**
	 * Get the checkin ID the comment was posted to.
	 * 
	 * @return The checkin ID
	 */
	public int getCheckinId() {
		return checkinId;
	}

	/**
	 * Set the checkin ID the comment was posted to.
	 * 
	 * @param checkinId
	 */
	public void setCheckinId(int checkinId) {
		this.checkinId = checkinId;
	}

	/**
	 * Get the report ID which the comment was posted to.
	 * 
	 * @return The report ID
	 */
	public int getReportId() {
		return reportId;
	}

	/**
	 * Set the report ID which the comment was posted to
	 * 
	 * @param reportId
	 *            The report ID
	 */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	/**
	 * Get the author of the comment
	 * 
	 * @return The name of the commenter
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Set the author of the comment
	 * 
	 * @param author
	 *            The name of the commenter
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the description of the comment. The actual comment passed
	 * 
	 * @return The comment passed.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the description of the comment.
	 * 
	 * @param description
	 *            The comment
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the date the comment was submitted
	 * 
	 * @return The submission date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Set the date the commented was submitted
	 * 
	 * @param date
	 *            The submission date.
	 */
	public void setDate(java.util.Date date) {
		this.date = new Date(date);
	}

	/**
	 * Get the comment id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Set the comment id
	 */
	public int setId(int id) {
		return this.id = id;
	}

	/**
	 * Get the comment email
	 */
	public int getEmail() {
		return this.id;
	}

	/**
	 * Set the comment email
	 */
	public int setEmail(int id) {
		return this.id = id;
	}

	@Override
	public String toString() {
		return "Comment [id:" + id + ", checkinId:" + checkinId
				+ ", report_id:" + reportId + ", author:" + author
				+ ", description:" + description + ", date:" + date
				+ ", email:" + email + ", ip:" + ip + ", spam:" + spam
				+ ", active:" + active + ", gmt:" + gmt + ", userId:" + userId
				+ "]";
	}
}
