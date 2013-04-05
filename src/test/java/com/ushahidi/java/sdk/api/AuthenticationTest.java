package com.ushahidi.java.sdk.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ushahidi.java.sdk.UshahidiException;
import com.ushahidi.java.sdk.api.json.Reports;
import com.ushahidi.java.sdk.api.tasks.BaseTask;
import com.ushahidi.java.sdk.api.tasks.BaseTaskTest;
import com.ushahidi.java.sdk.api.tasks.ReportsAdminTask;

public class AuthenticationTest extends BaseTaskTest {

	private ReportsAdminTask task;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createReportsAdminTask();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		task = null;
	}

	/**
	 * Test method for authenticating with incorrect username & password
	 */
	@Test
	public void testIncorrectCredential() {
		task.setAuthentication(USERNAME, PASSWORD+"FAIL");
		try {
			task.verified();
		} catch (UshahidiException ue) {
			String json = ue.getCause().getMessage();
			Reports r = BaseTask.fromString(json, Reports.class);
			assertEquals(r.getErrorCode(), 5);
			return;
		} catch (Exception e) {
			fail();
		}
		fail();
	}

	/**
	 * Test method for authenticating with correct username & password
	 */
	@Test
	public void testCorrectCredential() {
		try {
			task.setAuthentication(USERNAME, PASSWORD);
			task.verified();
		} catch (Exception e) {
			fail();
		}
	}

}
