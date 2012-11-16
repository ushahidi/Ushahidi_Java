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

import com.ushahidi.java.sdk.net.Authentication;
import com.ushahidi.java.sdk.net.PasswordAuthentication;

/**
 * 
 */
public abstract class AdminBaseTask extends BaseTask {

	private Authentication authentication;

	/**
	 * @param url
	 * @param task
	 */
	public AdminBaseTask(String url, String task, String username,
			String password) {
		super(url, task);

		if (username == null || username.isEmpty()) {
			throw new IllegalArgumentException(
					"Username may not be null or empty");
		}

		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException(
					"Password may not be null or empty");
		}
		
		authentication = new PasswordAuthentication(username, password);
		this.client.setAuthentication(authentication);
	}

}
