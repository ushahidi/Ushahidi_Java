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

import org.json.JSONException;

import com.ushahidi.java.sdk.Payload;
import com.ushahidi.java.sdk.api.Report;

/**
 * The ReportsTask implements all the task related to Reports task.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Reports"
 * >Ushahidi Public API for Reports</a>
 * 
 * @author eyedol
 * 
 */
public class ReportsTask extends Payload<Report> {

	/**
	 * The amount of reports to return at a time. 20 by default
	 */
	public int limit;

	/**
	 * Default constructor for ReportsTask. Sets the limit default value to 20.
	 */
	public ReportsTask(String url) {
		super(url);
		this.limit = 20;
	}

	/**
	 * Get all approved reports
	 * 
	 * @return A List containing all approved reports
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Report> all() {
		return null;
	}

	/**
	 * Get all report since a report id was created
	 * 
	 * @param id
	 *            The report ID
	 * @return A List containing all the report since a particular report ID was
	 *         created.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Report> sinceId(int id) {
		return null;
	}

	/**
	 * Get all report up to a certain certain report ID
	 * 
	 * @param id
	 *            The report maximum report ID
	 * @return A List containing all the reports within the specified maximum
	 *         report ID.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Report> maxId(int id) {
		return null;
	}

	/**
	 * Get a report by it's ID
	 * 
	 * @param id
	 *            The ID of the report
	 * @return The details of the reports retrieved.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public Report reportId(int id) {
		return null;
	}

	/**
	 * Get reports tagged by a location name.
	 * 
	 * @param name
	 *            The name of the location
	 * @return The report retrieved.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Report> locationName(String name) {
		return null;
	}

	/**
	 * Get reports by a location's ID
	 * 
	 * @param id
	 *            The location ID to use to retrieve the report
	 * @return The reports retrieved.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Report> locationId(int id) {
		return null;
	}

	/**
	 * Get reports by a category name.
	 * 
	 * @param category
	 *            The name of the category to use to retrieve the report
	 * @return The reports retrieved.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Report> categoryName(String category) {
		return null;
	}

	/**
	 * Get reports by a category ID.
	 * 
	 * @param id
	 *            The category ID
	 * @return The reports retrieved.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Report> categoryId(int id) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ushahidi.java.sdk.Payload#processModels()
	 */
	@Override
	public List<Report> processModels() {
		// TODO Auto-generated method stub
		return null;
	}
}
