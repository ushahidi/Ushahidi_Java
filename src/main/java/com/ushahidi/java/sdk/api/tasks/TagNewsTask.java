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

import com.ushahidi.java.sdk.api.TagMediaFields;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;

/**
 * Implements all task related to tagging an existing report with news item
 * 
 * @author eyedol
 * 
 */
public class TagNewsTask extends BaseTask {

	/** Form values */
	private TagMediaFields tagNewsFields;

	private static final String TASK = "tagnews";

	/**
	 * Creates the tagnews task
	 * 
	 * @param url
	 *            The Ushahidi deployment.
	 */
	public TagNewsTask(String url) {
		super(url, TASK);
	}

	public TagNewsTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
	}

	/**
	 * Tag an existing report with a news article
	 * 
	 * @param id
	 *            The ID of the existing report
	 * @param newsArticleUrl
	 *            A valid URL that links to an article related to the report
	 */
	public Response tagNews(int id, String newsArticleUrl) {

		tagNewsFields = new TagMediaFields(id, newsArticleUrl);

		return fromString(
				client.sendPostRequest(url,
						tagNewsFields.getParameters(tagNewsFields)),
				Response.class);

	}
}
