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
 * Test the Image utility class
 */
public class ImageTest extends BaseTaskTest {

	private static final String IMAGE_URL = "https://lh6.googleusercontent.com/-9p_YQnFQHog/UFyuJlaTYYI/AAAAAAAAH7A/VTeuTEaNLxw/s720/12%2520-%25201.jpg";

	private static final String DESTINATION = "/tmp";

	private static final String IMAGE_NAME = "motor.jpg";
	
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
	 * {@link com.ushahidi.java.sdk.util.Image#download(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testDownload() {
		Image.download(IMAGE_URL, IMAGE_NAME, DESTINATION);
		assertEquals(DESTINATION + IMAGE_NAME, DESTINATION + IMAGE_NAME);
	}

}
