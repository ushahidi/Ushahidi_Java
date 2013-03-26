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

/**
 * The class represents the Main response returned as a result of 
 * an Ushahidi API call.
 * 
 * @author eyedol
 *
 */
public class Response {
	
	protected static class Payload {
		protected String domain;
	}
	
	/**
	 * Error object
	 * 
	 * @author eyedol
	 *
	 */
	protected static class Error {
		protected String code;
		protected String message;
	}
	
	protected Error error;
	
	public int getErrorCode() {
		
		return Integer.valueOf(error.code);
	}
	
	public String getErrorMessage() {
		return error.message;
	}
	
	// for api that returns -- {"code":"001","message":"Missing Parameter - task."}
	public String code;
	
	public String message;
}
