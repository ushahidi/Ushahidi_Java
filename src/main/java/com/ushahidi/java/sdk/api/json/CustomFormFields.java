package com.ushahidi.java.sdk.api.json;

import java.util.List;

import com.ushahidi.java.sdk.api.CustomFormField;



public class CustomFormFields extends Response {
	
	private static class Payload extends Response.Payload {
		
		private static class _CustomFormsFields {
			private List<CustomFormField> fields;
		}

		private _CustomFormsFields customforms;
	
	}

	private Payload payload;
	
	public List<CustomFormField> getCustomFormsFields() {
		if (payload != null) {
			if (!error.code.equals("007")) {
				return payload.customforms.fields;
			}
		}
		return null;
	}

}
