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

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ushahidi.java.sdk.api.Category;
import com.ushahidi.java.sdk.api.CategoryFields;
import com.ushahidi.java.sdk.api.json.Response;
import com.ushahidi.java.sdk.net.content.FileBody;

/**
 * This class tests Ushahidi API categories task
 * 
 * @author eyedol
 * 
 */
public class CategoriesTaskTest extends BaseTaskTest {

	/** The categories task */
	private CategoriesTask task;

	/** The default category ID used in testing */
	private static final int CAT_ID = 1;
	
	/** The default category ID to use in testing category delete task */
	private static final int CATEGORY_ID = 68;

	private static final String USERNAME = "admin";

	private static final String PASSWORD = "admin";

	@Before
	public void setUp() throws Exception {
		super.setUp();
		task = factory.createCategoriesTask();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		task = null;
	}

	/**
	 * Test method for
	 * {@link com.ushahidi.java.sdk.api.tasks.CategoriesTask#all()}.
	 */
	@Test
	public void testAll() {
		List<Category> categories = task.all();
		assertNotNullOrEmpty("Categories list cannot be null or empty",
				categories);
	}

	/**
	 * Test method for fetching a category by it's ID
	 * {@link com.ushahidi.java.sdk.api.tasks.CategoriesTask#catId(int)}.
	 */
	@Test
	public void testCatId() {
		Category category = task.catId(CAT_ID);
		assertNotNull("Category cannot be null ", category);

	}

	/**
	 * Test method for Add a new category
	 * {@link com.ushahidi.java.sdk.api.tasks.CommentsTask#all()}.
	 */
	@Test
	public void testAdd() {
		String title = "New Category 2";
		String description = "Description";
		String color = "00ccff";
		int parentId = 0;
		FileBody fileBody = new FileBody(new File(
				"/home/eyedol/Pictures/maputo.jpg"));
		CategoryFields fields = new CategoryFields(0, parentId, title,
				description, color, fileBody);
		task.setAuthentication(USERNAME, PASSWORD);
		Response response = task.add(fields);
		assetNotNullOrZero(response.getErrorMessage(), response.getErrorCode());
	}

	/**
	 * Test Edit category
	 */
	@Test
	public void testEdit() {
		String title = "Category Edited";
		String description = "Description Edited";
		String color = "000000";
		FileBody fileBody = new FileBody(new File(
				"/home/eyedol/Pictures/maputo.jpg"));
		CategoryFields fields = new CategoryFields(11, 0, title, description,
				color, fileBody);
		task.setAuthentication(USERNAME, PASSWORD);
		Response response = task.edit(fields);
		System.out.println(response.getErrorMessage());
		assetNotNullOrZero(response.getErrorMessage(), response.getErrorCode());
	}

	/**
	 * Test delete category
	 */
	@Test
	public void testDelete() {
		task.setAuthentication(USERNAME, PASSWORD);
		Response response = task.delete(CATEGORY_ID);
		assetNotNullOrZero(response.getErrorMessage(), response.getErrorCode());
	}

}
