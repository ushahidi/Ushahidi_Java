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

import com.ushahidi.java.sdk.api.Comment;

/**
 * This class tests Ushahidi API comments test
 * 
 * @author eyedol
 * 
 */
public class CommentsTaskTest extends BaseTaskTest {

	/** The comment task */
	private CommentsTask task;

	/** The default report ID to use in testing */
	private static final int REPORT_ID = 68;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createCommentTask();
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
	public void testAll() {
		List<Comment> comments = task.all();
		assertNotNullOrEmpty("Comments list cannot be null or empty", comments);

	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#reportId(int)}.
	 */
	@Test
	public void testReportId() {
		List<Comment> comments = task.reportId(REPORT_ID);
		assertNotNullOrEmpty("Comments list cannot be null or empty", comments);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#spam()}.
	 */
	@Test
	public void testSpam() {
		//authenticate 
		task.getClient().setAuthentication(authentication);
		
		List<Comment> comments = task.spam();
		assertNotNullOrEmpty("Comments list cannot be null or empty", comments);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#pending()}.
	 */
	@Test
	public void testPending() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#approved()}.
	 */
	@Test
	public void testApproved() {
		fail("Not yet implemented");
	}

}
