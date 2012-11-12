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

	private static class Payload extends Response.Payload {

		private static class Incidents {

			private static class _Incident {
				private Incident report;
			}

			private static class Categories {
				private static class _Category {
					private Category category;
				}
			}

			private static class _Comment {
				private Comment comment;
			}

			private static class _Media {
				private Media media;
			}
		}

		private List<Incidents> reports;

		// private Incident report;

	}

	private Payload payload;

	/**
	 * Get the list of fetched reports
	 * 
	 * @return
	 */
	public List<Incident> getReports() {
		java.lang.System.out.println("Size: " + payload.reports);
		List<Incident> rep = new ArrayList<Incident>();
		/*
		 * for (Payload._Incident item : payload.reports) { Incident r =
		 * item.report; rep.add(r); }
		 */
		return rep;
	}

}
