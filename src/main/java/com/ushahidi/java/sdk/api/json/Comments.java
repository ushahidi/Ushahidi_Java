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

import com.ushahidi.java.sdk.api.Comment;

/**
 * @author eyedol
 * 
 */
public class Comments extends Response {

	private static class Payload extends Response.Payload {

		private static class _Comment {
			private Comment comment;
		}

		private List<_Comment> comments;

		private Comment comment;
	}

	private Payload payload;

	public List<Comment> getComments() {
		List<Comment> comt = new ArrayList<Comment>();
		if (payload != null) {
			// check if There are no results to show.
			if (!error.code.equals("007")) {
				if ((payload.comments != null) && (payload.comments.size() > 0)) {
					for (Payload._Comment item : payload.comments) {
						Comment c = item.comment;
						comt.add(c);
					}
				}
			}
		}
		return comt;
	}

	public Comment getComment() {
		return payload.comment;
	}
}
