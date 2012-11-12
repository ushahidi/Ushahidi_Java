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

	public CountriesTask(String url) {
		super(url);
	}

	/**
	 * Gets all countries.
	 * 
	 * @return The countries retrieves
	 * @throws IOException
	 * @throws JSONException
	 */
	public List<Country> all() {
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=countries");
		uriBuilder.append("&resp=json");

		final Countries countries = fromString(
				client.sendGetRequest(uriBuilder.toString()), Countries.class);
		return countries.getCountries();
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
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=country");
		uriBuilder.append("&by=countryid");
		uriBuilder.append("&id=" + String.valueOf(id));
		uriBuilder.append("&resp=json");

		final Countries countries = fromString(
				client.sendGetRequest(uriBuilder.toString()), Countries.class);
		return countries.getCountries();
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
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=country");
		uriBuilder.append("&by=countryiso");
		uriBuilder.append("&iso=" + iso);
		uriBuilder.append("&resp=json");

		final Countries countries = fromString(
				client.sendGetRequest(uriBuilder.toString()), Countries.class);
		return countries.getCountries();
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
		final StringBuilder uriBuilder = new StringBuilder(url);
		uriBuilder.append("/api?task=country");
		uriBuilder.append("&by=countryname");
		uriBuilder.append("&name=" + name);
		uriBuilder.append("&resp=json");

		final Countries countries = fromString(
				client.sendGetRequest(uriBuilder.toString()), Countries.class);
		return countries.getCountries();
	}

}
