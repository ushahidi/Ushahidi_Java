package com.ushahidi.java.sdk.api.json;

import java.util.List;

import com.ushahidi.java.sdk.api.CustomFormMeta;



public class CustomFormSchemas extends Response {
	
	private static class Payload extends Response.Payload {
		
		private static class _CustomFormsFields {
			private List<CustomFormMeta> fields;
		}

		private _CustomFormsFields customforms;
	
	}

	private Payload payload;
	
	public List<CustomFormMeta> getCustomFormMeta() {
		if (payload != null) {
			if (!error.code.equals("007")) {
				return payload.customforms.fields;
			}
		}
		return null;
	}

}
