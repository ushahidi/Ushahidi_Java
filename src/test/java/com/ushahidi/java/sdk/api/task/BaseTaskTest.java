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
package com.ushahidi.java.sdk.api.task;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import com.ushahidi.java.sdk.api.tasks.UshahidiApiTaskFactory;

/**
 * The base class for testing all the task supported by the Ushahidi API
 * 
 * @author eyedol
 * 
 */
public class BaseTaskTest extends TestCase {

	/** The factory class */
	protected UshahidiApiTaskFactory factory;

	/** Use the Ushahidi deployment to test */
	private static final String DEMO_DEPLOYMENT = "http://demo.ushahidi.com";

	@Before
	public void setUp() throws Exception {
		super.setUp();
		factory = UshahidiApiTaskFactory.newInstance(DEMO_DEPLOYMENT);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		// null the factory object
		factory = null;
	}

	/**
	 * Assert not null or empty.
	 * 
	 * @param message
	 *            the message
	 * @param value
	 *            the value
	 */
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}

	/**
	 * Assert not null or empty.
	 * 
	 * @param message
	 *            the message
	 * @param value
	 *            the value
	 */
	protected static void assertNotNullOrEmpty(String message,
			Collection<?> value) {
		assertNotNull(message, value);
		assertFalse(message, value.isEmpty());
	}
}
