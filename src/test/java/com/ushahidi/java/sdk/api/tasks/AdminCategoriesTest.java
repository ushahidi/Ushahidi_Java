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

import com.ushahidi.java.sdk.api.CategoryFields;

/**
 * 
 */
public class AdminCategoriesTest extends BaseTaskTest {

	/** The admin categories task **/
	private AdminCategoriesTask task;

	/** The default report ID to use in testing */
	private static final int REPORT_ID = 68;

	private static final String USERNAME = "admin";

	private static final String PASSWORD = "password";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createAdminCategoriesTask();
		task.setAuthentication(USERNAME, PASSWORD);
	}

	/**
	 * Free up the task object
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		task = null;
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#all()}.
	 */
	@Test
	public void testAdd() {
		String title = "hello";
		String description = "Description";
		String color = "#00000";
		CategoryFields fields = new CategoryFields(0, title, description,
				color, null);

		assetNotNullOrZero("Add a report cannot fail ", task.add(fields)
				.getErrorCode());
	}

	/**
	 * 
	 */
	@Test
	public void testEdit() {
		String title = "hello";
		String description = "Description";
		String color = "#00000";
		CategoryFields fields = new CategoryFields(1, title, description,
				color, null);
		assetNotNullOrZero("Delete a report cannot fail ", task.edit(fields)
				.getErrorCode());
	}

	@Test
	public void testDelete() {
		assetNotNullOrZero("Delete a report cannot fail ",
				task.delete(REPORT_ID).getErrorCode());
	}
}
