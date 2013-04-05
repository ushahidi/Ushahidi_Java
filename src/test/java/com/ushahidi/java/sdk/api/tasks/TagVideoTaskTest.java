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

/**
 * @author eyedol
 * 
 */
public class TagVideoTaskTest extends BaseTaskTest {

	private TagVideoTask task;

	private static final int REPORT_ID = 1068;

	private static final String URL = "http://www.youtube.com/watch?v=Zr4JwPb99qU";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createTagVideoTask();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		task = null;
	}

	@Test
	public void testTagVideo() {

		assertNotNull("Tag video cannot be null ",
				task.tagVideo(REPORT_ID, URL));
	}

}
