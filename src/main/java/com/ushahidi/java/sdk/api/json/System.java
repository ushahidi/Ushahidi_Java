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
package com.ushahidi.java.sdk.api.json;

import java.util.List;

/**
 * This class implements all methods and properties related to the Ushahidi
 * API's version resource
 * 
 * @author eyedol
 * 
 */
public class System extends Response {

	private static class Payload extends Response.Payload {

		private static class Version {

			private String version;

			private String database;

		}

		/** The Ushahidi deployment version information */
		private List<Version> version;

		/** Error */

		/** Checkins status **/
		private int checkins;

		/** The email attached to the Ushahidi deployment */
		private String email;

		/** The default SMS number */
		private String sms;

		/** The enabled plugins on the Ushahidi deployment */
		private List<String> plugins;

	}

	private Payload payload;

	/**
	 * Get the domain associated with the domain
	 * 
	 * @return The domain of the Ushahidi deployment
	 */
	public String getDomain() {
		return payload.domain;
	}

	/**
	 * Get the phone number configured on the Ushahidi deployment to send and
	 * receive SMS.
	 * 
	 * @return The configured phone number
	 */
	public String getSms() {
		return payload.sms;
	}

	/**
	 * Get the email attached to the Ushahidi deployment.
	 * 
	 * @return The email associated to the deployment
	 */
	public String getEmail() {
		return payload.email;
	}

	/**
	 * Get status of checkins. 1 for enabled and 0 for disable.
	 * 
	 * @return The status of checkins
	 */
	public int getCheckins() {
		return payload.checkins;
	}

	/**
	 * Get all the enabled plugins
	 * 
	 * @return The enabled plugins
	 */
	public List<String> getPlugins() {
		return payload.plugins;
	}
	
	

	/**
	 * Get version info
	 */
	public List<Payload.Version> getVersion() {
		return payload.version;
	}

}
