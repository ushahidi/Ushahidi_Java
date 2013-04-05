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
import com.ushahidi.java.sdk.api.CommentFields;
import com.ushahidi.java.sdk.api.json.Response;

/**
 * This class tests Ushahidi API comments
 * 
 * @author eyedol
 * 
 */
public class CommentsTaskTest extends BaseTaskTest {

	/** The comment task */
	private CommentsTask task;

	/** The default report ID to use in testing */
	private static final int REPORT_ID = 1068;

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
	 * <p>
	 * For this test to pass, make sure a comment has been marked spam in the
	 * Ushahidi deployment.
	 * </p>
	 */
	@Test
	public void testSpam() {
		// authenticate
		List<Comment> comments = task.spam();
		assertNotNullOrEmpty("Spam comments list cannot be null or empty",
				comments);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#pending()}.
	 */
	@Test
	public void testPending() {
		List<Comment> comments = task.pending();
		assertNotNullOrEmpty("Pending comments list cannot be null or empty",
				comments);
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#approved()}.
	 */
	@Test
	public void testApproved() {
		List<Comment> comments = task.approved();
		assertNotNullOrEmpty("Approved comments list cannot be null or empty",
				comments);
	}

	/**
	 * Test for {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#submit()}
	 * 
	 */
	@Test
	public void testSubmit() {
		Comment c = new Comment();
		c.setAuthor("Henry Addo");
		c.setReportId(REPORT_ID);
		c.setDescription("Some sample comments");

		CommentFields comment = new CommentFields();
		comment.fill(c);
		comment.setEmail("henry@ushahidi.com");
		Response response = task.submit(comment);
		System.out.println(response.getErrorMessage());
		assertEquals("Comment couldn't be submitted", 0,
				response.getErrorCode());
	}
}
