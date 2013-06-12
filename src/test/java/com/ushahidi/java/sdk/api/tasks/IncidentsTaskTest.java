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

import com.ushahidi.java.sdk.api.Incidents;

/**
 * The report task test
 * 
 * @author eyedol
 */
public class IncidentsTaskTest extends BaseTaskTest {

    private IncidentsTask task;

    private static final int SINCE_ID = 1;

    private static final int MAX_ID = 1083;

    private static final int REPORT_ID = 1068;

    private static final int LOCATION_ID = 1083;

    private static final int CATEGORY_ID = 1;

    private static final String LOCATION_NAME = "Adana/Adana Province, Turkey";

    private static final String CATEGORY_NAME = "Category 1";

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        task = factory.createIncidentsTask();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        super.tearDown();
        task = null;
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#all()} .
     */
    @Test
    public void testAll() {
        assertNotNullOrEmpty("List report all cannot be null or empty",
                task.all());
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#sinceId(int)}.
     */
    @Test
    public void testSinceId() {
        assertNotNullOrEmpty("Reports by since id cannot be null or empty",
                task.sinceId(SINCE_ID));
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#maxId(int)}.
     */
    @Test
    public void testMaxId() {
        assertNotNullOrEmpty("Reports by max id cannot be null or empty",
                task.maxId(MAX_ID));
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#reportId(int)}.
     */
    @Test
    public void testReportId() {

        assertNotNull("Report by id cannot be null or empty",
                task.reportId(REPORT_ID));
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#locationName(java.lang.String)}
     * .
     */
    @Test
    public void testLocationName() {

        assertNotNullOrEmpty("Report by location name",
                task.locationName(LOCATION_NAME));
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#locationId(int)}.
     */
    @Test
    public void testLocationId() {
        assertNotNullOrEmpty("Reports by location ID",
                task.locationId(LOCATION_ID));
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#categoryName(java.lang.String)}
     * .
     */
    @Test
    public void testCategoryName() {
        assertNotNullOrEmpty("Report by category name cannot be null or empty",
                task.categoryName(CATEGORY_NAME));
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#categoryId(int)}.
     */
    @Test
    public void testCategoryId() {
        assertNotNullOrEmpty("Report by category ID",
                task.categoryId(CATEGORY_ID));
    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#setLimit(int)} Test
     * for how many incident to retrieve at a time
     */
    public void testSetLimit() {
        // Set the limit
        task.setLimit(2);

        // Now retrieve all report
        List<Incidents> reports = task.all();

        assertEquals("Expect it to return 2 records", 2, reports.size());

    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#setSort(int)} Sort
     * by Ascending
     */
    public void testSetSort() {
        // Set the sort by
        task.setSort(1);

        // Now retrieve all report
        List<Incidents> reports = task.all();

        assertNotNullOrEmpty("Cannot be NULL or empty", reports);

    }

    /**
     * Test method for
     * {@link com.ushahidi.java.sdk.api.tasks.IncidentsTask#setLimit(int)} Order
     * by incidentdate
     */
    public void testOrderField() {
        // Set the limit
        task.setOrderField("incidentdate");

        // Now retrieve all report
        List<Incidents> reports = task.all();
        assertNotNullOrEmpty("Cannot be NULL or empty", reports);

    }

}
