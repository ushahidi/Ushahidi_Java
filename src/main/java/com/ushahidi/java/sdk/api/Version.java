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
package com.ushahidi.java.sdk.api;

/**
 * This class implements all methods and properties related to the Version API
 * call
 * 
 * @author eyedol
 * 
 */
public class Version {

	/** The Ushahidi deployment version number **/
	private String version;

	/** The Ushahidi deployment database version **/
	private String database;

	/**
	 * Set the current version number of the Ushahidi deployment as retrieved
	 * via the API call.
	 * 
	 * @param version
	 *            The version number
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Get the current version number of the Ushahidi deployment as retreived
	 * via the API call.
	 * 
	 * @return The version number
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * Set the Ushahidi database version number
	 * 
	 * @param database
	 *            The database version number
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * Get the Ushahidi database version number
	 * 
	 * @return The database version
	 */
	public String setDatabase() {
		return this.database;
	}
}
