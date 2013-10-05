package com.ushahidi.java.sdk.api.json;

import java.util.List;

import com.ushahidi.java.sdk.api.CustomForm;

/**
 * This class is used to retrieve the list of custom forms used
 * @author marco
 *
 */
public class CustomForms extends Response {
	
	private static class Payload extends Response.Payload {
		private List<CustomForm> customforms;
	}

	private Payload payload;
	
	public List<CustomForm> getCustomForms() {
		if (payload != null) {
			if (!error.code.equals("007")) {
				return payload.customforms;
			}
		}
		return null;
	}
}
