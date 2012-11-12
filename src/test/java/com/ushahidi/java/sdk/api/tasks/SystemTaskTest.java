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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ushahidi.java.sdk.api.json.System;

/**
 * The SystemInfoTask to be tested
 * 
 * TODO: test the various methods as defined in the SystemInfoTask class
 * 
 * @author eyedol
 * 
 */
public class SystemTaskTest extends BaseTaskTest {

	private SystemTask task;

	private System system;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createSystemTask();

		// system info
		system = task.fetch();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		task = null;
		system = null;
	}

	@Test
	public void testFetch() {
		assertNotNull("Category cannot be null ", system);
	}

	/**
	 * Test the error code as received from the API call
	 */
	@Test
	public void testErrorCode() {
		assertNotNull("Error code cannot be null ", system.getErrorCode());
	}

	/**
	 * Test the error code as received from the API call
	 */
	@Test
	public void testErrorMessage() {
		assertNotNull("Error message cannot be null ", system.getErrorMessage());
	}

	@Test
	public void testVersion() {
		assertNotNull("Version number cannot be null ", system.getVersion());
	}

	@Test
	public void testCheckins() {
		assertNotNull("Checkins cannot be null ", system.getCheckins());
	}

	@Test
	public void testSms() {
		assertNotNull("SMS cannot be null ", system.getSms());
	}

	@Test
	public void testEmail() {
		assertNotNull("Email cannot be null", system.getEmail());
	}

	@Test
	public void testPlugins() {
		assertNotNull("Plugins cannot be null", system.getPlugins());
	}
}
