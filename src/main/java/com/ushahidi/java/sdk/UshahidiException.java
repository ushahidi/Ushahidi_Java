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
package com.ushahidi.java.sdk;

/**
 * Handles all Runtime Exception
 * 
 * @author eyedol
 * 
 */
public class UshahidiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6639204130451563983L;

	/**
	 * Instantiates a new Ushahidi exception.
	 */
	public UshahidiException() {
	}

	/**
	 * Instantiates a new Ushahidi exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public UshahidiException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * @param message
	 *            The message be shown
	 */
	public UshahidiException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 *            The message to be shown.
	 * @param cause
	 *            The cause of the exception.
	 */
	public UshahidiException(String message, Throwable cause) {
		super(message, cause);
	}
}
