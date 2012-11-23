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
package com.ushahidi.java.sdk.api;

/**
 * The Country class implements all the properties and methods of the Ushahidi
 * API's country resource
 * 
 * @author eyedol
 * 
 */
public class Country {

	/**
	 * The country id
	 */
	private int id;

	/**
	 * The name of the country. Eg. Ghana
	 */
	private String name;

	/**
	 * The ISO code for the country. Eg. gh for Ghana
	 */
	private String iso;

	/**
	 * The country
	 */
	private String country;

	/**
	 * The capital city of the captital. Eg. Accra, Ghana's capital city.
	 */
	private String capital;

	/**
	 * The total number of cities retrieved for the country
	 */
	private int cities;

	/**
	 * Get the name of the country.
	 * 
	 * @return Country's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the country
	 * 
	 * @param name
	 *            The name of the country
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the ISO code of the country
	 * 
	 * @return The ISO code
	 */
	public String getIso() {
		return iso;
	}

	/**
	 * Set the ISO code of the country
	 * 
	 * @param iso
	 *            The country's ISO code
	 */
	public void setIso(String iso) {
		this.iso = iso;
	}

	/**
	 * Get the country retrieved via the API call
	 * 
	 * @return The ccountry
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the country retrieved via the API call
	 * 
	 * @param country
	 *            The country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get the capital town of the country
	 * 
	 * @return The capital town
	 */
	public String getCapital() {
		return this.capital;
	}

	/**
	 * Set the capital town of the country as retrieved from the API call
	 * 
	 * @param capital
	 *            The capital town of the country
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * Get the total number cities as retrieved via the API call
	 * 
	 * @return The total number cities
	 */
	public int getCities() {
		return cities;
	}

	/**
	 * Set the total number cities as retrieved via the API call
	 * 
	 * @param cities
	 *            The total number of cities
	 */
	public void setCities(int cities) {
		this.cities = cities;
	}

	/**
	 * Get the comment id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Set the comment id
	 */
	public int setId(int id) {
		return this.id = id;
	}

	@Override
	public String toString() {
		return "Country [id:" + id + ", name:" + name + ", country:" + country
				+ ", capital:" + capital + ", cities:" + cities + "]";
	}
}
