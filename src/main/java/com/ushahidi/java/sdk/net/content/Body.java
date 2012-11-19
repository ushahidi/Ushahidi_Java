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
package com.ushahidi.java.sdk.net.content;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a form body that can be used as a part of multi-part
 * encoded entities for making a mulit-part HTTP request
 * 
 * @author eyedol
 * 
 */
public class Body {

	private List<Field> formField;

	public Body() {
		formField = new ArrayList<Field>();
	}

	/**
	 * Add a form field for them to be submitted via a HTTP request
	 * 
	 * @param name
	 *            The form field name
	 * @param value
	 *            The form field value
	 */
	public void addField(String name, Object value) {
		if ( value == null){
			return;
		}
		List<Object> list ;
		if (!( value instanceof List)){
			list = new ArrayList<Object>();
			list.add(value);
		}else{
			list = (List<Object>) value;
		}
		for (Object o : list) {
			if ( o instanceof File){
				o = new FileBody((File)o);
			}
			Field field = new Field(name, o);
			formField.add(field);
		}
	}

	/**
	 * Get The form fields to be submitted via a HTTP request
	 * 
	 * @return The form fields
	 */
	public List<Field> getFields() {
		return formField;
	}

}
