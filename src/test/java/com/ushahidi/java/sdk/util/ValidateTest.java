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
package com.ushahidi.java.sdk.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ushahidi.java.sdk.api.tasks.BaseTaskTest;

/**
 * 
 */
public class ValidateTest extends BaseTaskTest {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.util.Validate#email(java.lang.String)}.
	 */
	@Test
	public void testEmail() {

		assertTrue("Provide a validate email ",
				Validate.email("henry@ushahidi.com"));
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.util.Validate#empty(java.lang.String)}.
	 */
	@Test
	public void testEmpty() {
		String field = "";
		assertTrue("This field cannot be empty", Validate.empty(field));
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.util.Validate#range(java.lang.String, int, int)}
	 * .
	 */
	@Test
	public void testRange() {
		String field = "hellohenry";
		assertTrue("Cannot be more than 11 characters long",
				Validate.range(field, 0, 11));
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.util.Validate#url(java.lang.String)}.
	 */
	@Test
	public void testUrl() {
		String url = "http://www.addhen.org";
		assertTrue("Provide a valid URL ", Validate.url(url));
	}

}
