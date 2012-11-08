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
import com.ushahidi.java.sdk.api.Location;

/**
 * The Location Task Implements all tasks related to the Location API.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Locations"
 * >Ushahidi Public API</a> for more details
 * 
 * @author eyedol
 * 
 */
public class LocationTask extends BaseTask {

	public LocationTask(String url) {
		super(url);
	}

	/**
	 * Gets all locations
	 * 
	 * @return All location
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Location> all() {
		return null;
	}

	/**
	 * Get a specific location by it's ID
	 * 
	 * @param id
	 *            The ID of the location
	 * @return The location retrieved by ID
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public Location locationId(int id) {
		return null;
	}

	/**
	 * Get a specific location by a country's ID
	 * 
	 * @param id
	 *            The ID of the country to be used to retrieve the location.
	 * @return The location retrieved by the country's ID
	 * @throws IOException
	 * @throws JSONException
	 */
	public Location countryId(int id) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ushahidi.java.sdk.Payload#processModels()
	 */
	@Override
	public List<Location> processModels() {
		// TODO Auto-generated method stub
		return null;
	}

}
