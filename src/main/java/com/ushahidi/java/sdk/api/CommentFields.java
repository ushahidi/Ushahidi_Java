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

/**
 * 
 */
public class CommentFields extends Form {
	@FormField(name = "incident_id")
	private int incidentId;

	@FormField(name = "comment_author")
	private String author;

	@FormField(name = "comment_description")
	private String description;

	@FormField(name = "comment_email")
	private String email;

	public void fill(Comment c) {
		incidentId = c.getReportId();
		author = c.getAuthor();
		description = c.getDescription();
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
