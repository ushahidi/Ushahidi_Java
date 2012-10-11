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

import java.util.List;

import com.ushahidi.java.sdk.Payload;
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

	public CommentsTask() {
		super();
	}

	/**
	 * Get all comments.
	 * 
	 * @return The fetched comments
	 */
	public List<Comment> all() {
		return null;
	}

	/**
	 * Get all comments for a specific report.
	 * 
	 * @param id
	 *            The report id
	 * @return The comments associated to the specified report id
	 */
	public List<Comment> reportId(int id) {
		return null;
	}

	/**
	 * Get all comment marked as spam.
	 * 
	 * @return The spam comments
	 */
	public List<Comment> spam() {
		return null;
	}

	/**
	 * Get all pending comment
	 * 
	 * @return The pending comment
	 */
	public List<Comment> pending() {
		return null;
	}

	/**
	 * Get all approved comments
	 * 
	 * @return The approved comments
	 */
	public List<Comment> approved() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ushahidi.java.sdk.Payload#setModels(java.util.List)
	 */
	@Override
	public void setModels(List<Comment> models) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ushahidi.java.sdk.Payload#getModels()
	 */
	@Override
	public List<Comment> getModels() {
		// TODO Auto-generated method stub
		return null;
	}
}
