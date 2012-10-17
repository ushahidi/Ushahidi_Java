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
 * 
 * @author eyedol
 * 
 */
public class SystemInfo extends Model {

	/** The Ushahidi deployment version information */
	private Version version;

	/** Checkins status **/
	private int checkins;

	/** The email attached to the Ushahidi deployment */
	private String email;

	/** The default SMS number */
	private String sms;

	/** The enabled plugins on the Ushahidi deployment */
	private String plugins[];

	/**
	 * Set the version details of the Ushahidi deployment
	 * 
	 * @param version
	 *            The version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * Get the version details of the Ushahidi deployment. Both database version
	 * number the installed Ushahidi version number
	 * 
	 * @return The Ushahidi deployment version details
	 */
	public Version getVersion() {
		return this.version;
	}

	/**
	 * Set the checkin status on the Ushahidi deployment. 0 means checkins has
	 * been disabled on the Ushahidi deployment and 1 for enabled.
	 * 
	 * @param checkins
	 *            The checkin status. 0 disabled and 1 enabled
	 */
	public void setCheckins(int checkins) {
		this.checkins = checkins;
	}

	/**
	 * Get the checkin status
	 * 
	 * @return The status of the checkin
	 */
	public int getCheckins() {
		return this.checkins;
	}

	/**
	 * Set the default email as set on the Ushahidi deployment.
	 * 
	 * @param email
	 *            The default email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the default email associated with the Ushahidi deployment.
	 * 
	 * @return The default email.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Set the default SMS number as configured on the Ushahidi deployment. This
	 * the number users send SMS to and receive SMS from.
	 * 
	 * @param sms
	 *            The phone number. It includes the country code if it's set on
	 *            the Ushahidi deployment
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * Get the SMS number
	 * 
	 * @return The phone number.
	 */
	public String getSms() {
		return this.sms;
	}

	/**
	 * Set the plugins that are enabled on the Ushahidi deployments.
	 * 
	 * @param plugins
	 *            An <code>Array</code> containing enabled plugins
	 */
	public void setPlugins(String[] plugins) {
		this.plugins = plugins;
	}

	/**
	 * Get the plugins that are enabled on the Ushahid deployments.
	 * 
	 * @return The enabled plugins
	 */
	public String[] getPlugins() {
		return this.plugins;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ushahidi.java.sdk.api.Model#setId(int)
	 */
	@Override
	protected void setId(int id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ushahidi.java.sdk.api.Model#getId()
	 */
	@Override
	public int getId() {
		return 0;
	}

}
