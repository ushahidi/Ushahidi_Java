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

import com.ushahidi.java.sdk.api.Location;

/**
 * Test the location task
 * 
 * @author eyedol
 * 
 */
public class LocationTaskTest extends BaseTaskTest {

	private LocationTask task;

	/** The default location ID */
	private static final int LOCATION_ID = 455;

	private static final int COUNTRY_ID = 115;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createLocationTask();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		task = null;
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.LocationTask#all()}.
	 */
	@Test
	public void testAll() {
		List<Location> locations = task.all();
		assertNotNullOrEmpty("Location list cannot be null or empty", locations);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.LocationTask#locationId(int)}.
	 */
	@Test
	public void testLocationId() {
		List<Location> locations = task.locationId(LOCATION_ID);
		assertNotNull("Location by ID cannot be null", locations);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.LocationTask#countryId(int)}.
	 */
	@Test
	public void testCountryId() {
		List<Location> locations = task.countryId(COUNTRY_ID);
		assertNotNull("Location by country ID cannot be null", locations);
	}

}
