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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ushahidi.java.sdk.api.Country;

/**
 * This class tests {@link CountriesTask}CountriesTask
 * 
 * @author eyedol
 * 
 */
public class CountriesTaskTest extends BaseTaskTest {

	/** The countries task */
	private CountriesTask task;

	/** The default country id to use */
	private static final int ID = 247;

	/** The default country ISO to use */
	private static final String ISO = "gh";

	/** The default country name to use */
	private static final String NAME = "ghana";

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createCountriesTask();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.setUp();
		task = null;
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CountriesTask#all()}.
	 */
	@Test
	public void testAll() {
		List<Country> countries = task.all();
		assertNotNullOrEmpty("Countries list cannot be null or empty",
				countries);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CountriesTask#countryId(int)}.
	 */
	@Test
	public void testCountryId() {
		List<Country> countries = task.countryId(ID);
		assertNotNull("Country by id cannot be null or empty", countries);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CountriesTask#countryIso(java.lang.String)}
	 * .
	 */
	@Test
	public void testCountryIso() {
		List<Country> countries = task.countryIso(ISO);
		assertNotNull("Country by iso cannot be null or empty", countries);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CountriesTask#countryName(java.lang.String)}
	 * .
	 */
	@Test
	public void testCountryName() {
		List<Country> countries = task.countryName(NAME);
		assertNotNull("Country by name cannot be null or empty", countries);
	}

}
