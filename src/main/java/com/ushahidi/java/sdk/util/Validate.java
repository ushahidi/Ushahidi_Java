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
package com.ushahidi.java.sdk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provide validation method for the various fields
 */
public class Validate {

	private static final String VALID_EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static Pattern pattern;

	private static Matcher matcher;

	public static boolean email(String email) {
		pattern = Pattern.compile(VALID_EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Validate an empty field/string. Return true if the string is empty
	 * 
	 * @param field
	 *            The string to validate
	 * @return true if is empty otherwise false
	 */
	public static boolean empty(String field) {
		if (field == null || field.length() == 0)
			return true;
		return false;
	}

	/**
	 * Validate how long a field can be
	 * 
	 * @param field
	 *            The field
	 * @param start
	 *            Range starts
	 * @param end
	 *            Range ends
	 * @return True if the field is within range
	 */
	public static boolean range(String field, int start, int end) {
		if (field == null)
			return false;

		int length = field.length();

		if (end >= length)
			end = length - 1;

		return (start >= 0) && (end >= 0) && (start <= end) && (length > 0);
	}

	/**
	 * Validate a URL
	 * 
	 * @param url
	 *            The URL to be validated
	 * 
	 * @return True if the field is within range
	 */
	public static boolean url(String url) {
		Pattern p = Pattern.compile("^(https?|ftp|file)://.+$");
		Matcher m = p.matcher(url);
		return m.matches();
	}

	/**
	 * Remove trailing slashes
	 * 
	 * @param url
	 * @return 
	 */
	public static String removeTrailingSlashes(String url) {
		if (url.endsWith("/")) {
			return url.substring(0, url.length() - 1);
		}
		return url;
	}

}
