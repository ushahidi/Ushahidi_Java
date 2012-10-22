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
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.ushahidi.java.sdk.Payload;
import com.ushahidi.java.sdk.api.Country;

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
public class CountriesTask extends Payload<Country> {

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
		return null;
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
	public Country countryId(int id) {
		return null;
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
	public Country countryIso(String iso) {
		return null;
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
	public Country countryName(String name) {
		return null;
	}

	/**
	 * Process the JSON data to get the data associated with a country
	 * 
	 * @see com.ushahidi.java.sdk.Payload#processModels()
	 */
	@Override
	public List<Country> processModels() {
		List<Country> countries = new ArrayList<Country>();
		try {
			if(!getPayloadObj().isNull("countries")) {
				JSONArray countriesArr = getPayloadObj()
						.getJSONArray("countries");
				if(countriesArr != null) {
					for(int i = 0; i < countriesArr.length();i++) {
						Country country = new Country();
						country.setId( countriesArr.getJSONObject(i)
						.getJSONObject("country").getInt("id"));
					}
				}
				return countries;
			}
		}catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

}
