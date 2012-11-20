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
import com.ushahidi.java.sdk.api.Country;
import com.ushahidi.java.sdk.api.json.Countries;

/**
 * Implements all tasks related to countries.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Countries"
 * >Ushahidi Public API</a> for more details
 * 
 * @author eyedol
 * 
 */
public class CountriesTask extends BaseTask {

	private static final String TASK = "countries";

	public CountriesTask(String url) {
		super(url, TASK);
	}

	/**
	 * Gets all countries.
	 * 
	 * @return The countries retrieves
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Country> all() {

		return fromString(sendGetRequest(url), Countries.class).getCountries();
	}

	/**
	 * Get a country by it's ID
	 * 
	 * @param id
	 *            The ID of the country
	 * @return The country retrieved
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Country> countryId(int id) {

		setRequestParameters("by", "countryid");
		setRequestParameters("id", String.valueOf(id));

		return fromString(sendGetRequest(url), Countries.class).getCountries();
	}

	/**
	 * Get a country by it's ISO code.
	 * 
	 * @param iso
	 *            The country's ISO code. Eg gh for Ghana.
	 * @return The country retrieved
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Country> countryIso(String iso) {

		setRequestParameters("by", "countryiso");
		setRequestParameters("iso", iso);
		return fromString(sendGetRequest(url), Countries.class).getCountries();
	}

	/**
	 * Get a country by it's name
	 * 
	 * @param name
	 *            The name of the country to be used to retrieve the details of
	 *            that country. Eg. ghana
	 * @return The country retrieved
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Country> countryName(String name) {
		setRequestParameters("by", "countryname");
		setRequestParameters("name", name);
		return fromString(sendGetRequest(url), Countries.class).getCountries();
	}

}
