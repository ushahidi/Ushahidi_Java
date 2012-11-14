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

import com.ushahidi.java.sdk.api.TagNewsFields;
import com.ushahidi.java.sdk.api.json.Response;

/**
 * Implements all task related to tagging an existing report with news item
 * 
 * @author eyedol
 * 
 */
public class TagNewsTask extends BaseTask {

	/** Form values */
	private TagNewsFields tagNewsFields;

	/** The response received from the server as a result of making an API call. */
	public Response response;

	/**
	 * Creates the tagnews task
	 * 
	 * @param url
	 *            The Ushahidi deployment.
	 */
	public TagNewsTask(String url) {
		super(url);
	}

	/**
	 * Tag an existing report with a news article
	 * 
	 * @param id
	 *            The ID of the existing report
	 * @param newsArticleUrl
	 *            A valid URL that links to an article related to the report
	 */
	public void tagNews(int id, String newsArticleUrl) {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=tagnews");
		uriBuilder.append("&resp=json");

		tagNewsFields = new TagNewsFields(id, newsArticleUrl);

		response = fromString(
				client.sendPostRequest(newsArticleUrl,
						tagNewsFields.getFormParameters(tagNewsFields)),
				Response.class);

	}
}
