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

import java.util.ArrayList;
import java.util.List;

/**
 * @author eyedol
 * 
 */
public class Countries extends Response {

	private static class Payload extends Response.Payload {

		private static class _Country {
			private Country country;
		}

		private List<_Country> countries;

		private Country country;
	}

	private Payload payload;

	public List<Country> getCountries() {
		List<Country> comt = new ArrayList<Country>();
		for (Payload._Country item : payload.countries) {
			Country c = item.country;
			comt.add(c);
		}
		return comt;
	}

	public Country getCountry() {
		return payload.country;
	}
}
