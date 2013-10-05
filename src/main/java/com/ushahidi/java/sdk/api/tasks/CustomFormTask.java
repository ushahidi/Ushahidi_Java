
package com.ushahidi.java.sdk.api.tasks;

import java.util.List;

import com.ushahidi.java.sdk.api.CustomForm;
import com.ushahidi.java.sdk.api.CustomFormField;
import com.ushahidi.java.sdk.api.CustomFormMeta;
import com.ushahidi.java.sdk.api.json.CustomFormFields;
import com.ushahidi.java.sdk.api.json.CustomFormSchemas;
import com.ushahidi.java.sdk.api.json.CustomForms;
import com.ushahidi.java.sdk.net.UshahidiHttpClient;



/**
 * Implements all tasks related to Custom Forms.
 * 
 * See <a href=
 * "https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API#UshahidiPublicAPI-Categories"
 * >Ushahidi Public API </a> for more details
 * 
 * @author markov00
 * 
 */
public class CustomFormTask extends BaseTask {
	private static final String TASK = "customforms";
	public String response;
	
	private CustomForms customForm;
	
	/**
	 * Create the CustomFormTask task
	 * 
	 * @param url
	 *            The URL of the Ushahidi deployment
	 */
	public CustomFormTask(String url) {
		super(url, TASK);
	}

	/**
	 * Create the CustomFormTask task
	 * 
	 * @param url
	 *            The URL of the Ushahidi deployment
	 */
	public CustomFormTask(String url, UshahidiHttpClient client) {
		super(url, TASK, client);
	}
	
	
	/**
	 * Get the available custom form ids from the current Ushahidi deployment
	 * @return a list of custom forms
	 */
	public List<CustomForm> getAvailableCustomForms() {
		client.setRequestParameters("by", "all");
		response = client.sendGetRequest(url);
		customForm = fromString(response, CustomForms.class);
		return customForm.getCustomForms();
	}
	
	/**
	 * Get the values of the custom form used in a specific incidentId
	 * @param incidentId the incident Id
	 * @return a list of CustomFormField object representing the value of the custom form
	 * for a specific incident id
	 */
	public List<CustomFormField> getCustomFormsFieldsByIncidentId(int incidentId) {
		client.setRequestParameters("by", "fields");
		client.setRequestParameters("id", String.valueOf(incidentId));
		response = client.sendGetRequest(url);
		CustomFormFields cf  = fromString(response, CustomFormFields.class);
		return cf.getCustomFormsFields();
	}
	
	/**
	 * Get the meta description of a custom form
	 * @param formId the form id retrieved via getAvailableCustomForms()
	 * @return a list of custom form meta objects that represent the schema of the custom form
	 */
	public List<CustomFormMeta> getCustomFormsMetaByFormId(int formId) {
		client.setRequestParameters("by", "meta");
		client.setRequestParameters("formid", String.valueOf(formId));
		response = client.sendGetRequest(url);
		CustomFormSchemas cf  = fromString(response, CustomFormSchemas.class);
		return cf.getCustomFormMeta();
	}



}