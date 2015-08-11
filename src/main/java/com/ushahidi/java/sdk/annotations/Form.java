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
package com.ushahidi.java.sdk.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.ushahidi.java.sdk.net.content.Body;

/**
 * @author eyedol
 * 
 */
public class Form {

	/**
	 * Get the form parameters to be submitted
	 * 
	 * @param obj The form field
	 * 
	 * @return The Map objection that has the forms variable names and values
	 */
	public Body getParameters(Object obj) {
		Body body = new Body();
		// get all declared files
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			// get all the annotations
			try {
				Annotation[] annotations = field.getAnnotations();
				for (Annotation annotation : annotations) {
					if (annotation instanceof FormField) {
						FormField formField = (FormField) annotation;
						if (!field.isAccessible()) {
							field.setAccessible(true);
						}
						// add the form fields
						body.addField(formField.name(), field.get(obj));
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return body;
	}

}
