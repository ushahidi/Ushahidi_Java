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

/**
 * This Comment class has all properties and methods of a comment
 * 
 * @author eyedol
 * 
 */
public class Comment extends Model{
	
	/**
	 * The unique ID for the comment
	 */
	private int id;
	
	/**
	 * The unique ID of a checking
	 */
	private int checkinId;

	/**
	 * The unique ID of a report
	 */
	private int reportId;

	/**
	 * The name of the person who submitted the comment
	 */
	private String author;

	/**
	 * The description of the comment. This in fact the actual comment passed 
	 */
	private String description;

	/**
	 * The date the comment was submitted.
	 */
	private String date;

	/**
	 * Get the ID of the comment
	 * @return The comment ID
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Set the comment ID
	 * 
	 * @param id The comment ID
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

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
	 * @param reportId The report ID
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
	 * @param author The name of the commenter
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
	 *  Set the description of the comment. 
	 *  
	 * @param description The comment
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the date the comment was submitted
	 * 
	 * @return The submission date
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * Set the date the commented was submitted
	 * 
	 * @param date The submission date.
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
