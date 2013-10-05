package com.ushahidi.java.sdk.api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ushahidi.java.sdk.annotations.Form;
import com.ushahidi.java.sdk.annotations.FormCustomField;
import com.ushahidi.java.sdk.annotations.FormField;

public class ReportFields extends Form {

	// incident
	@FormField(name = "incident_title")
	private String title;
	@FormField(name = "incident_description")
	private String description;
	@FormField(name = "incident_date")
	private String date;
	@FormField(name = "incident_hour")
	private String hour;
	@FormField(name = "incident_minute")
	private String minute;
	@FormField(name = "incident_ampm")
	private String ampm;
	@FormField(name = "incident_category")
	private String category;
	@FormField(name = "latitude")
	private String latitude;
	@FormField(name = "longitude")
	private String longitude;
	@FormField(name = "location_name")
	private String locationName;
	@FormField(name = "incident_photo[]")
	private List<File> photo = new ArrayList<File>();
	@FormField(name = "incident_video[]")
	private List<String> video = new ArrayList<String>();
	@FormField(name = "incident_news[]")
	private List<String> news = new ArrayList<String>();
	@FormField(name = "form_id")
	private String formId;
	@FormCustomField
	private Map<String,String> customFields= new HashMap<String, String>();
	

	// person
	@FormField(name = "person_first")
	private String firstName;
	@FormField(name = "person_last")
	private String lastName;
	@FormField(name = "person_email")
	private String email;

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(
			"MM/dd/yyyy h m a", Locale.US);

	public void fill(Incident i) {
		title = i.getTitle();
		description = i.getDescription();
		Date d = i.getDate();
		String parts[] = FORMATTER.format(d).split(" ");
		date = parts[0];
		hour = parts[1];
		minute = parts[2];
		ampm = parts[3].toLowerCase();
		locationName = i.getLocationName();
		latitude = String.valueOf(i.getLatitude());
		longitude = String.valueOf(i.getLongitude());
	}

	public void addCategory(List<Category> cats) {
		for (Category cat : cats) {
			addCategory(cat.getId());
		}
	}

	public void addCategory(int id) {
		String idStr = String.valueOf(id);
		category = null == category ? idStr : category + "," + idStr;
	}

	public void addVideo(String... urls) {
		video.addAll(Arrays.asList(urls));
	}

	public void addVideo(List<String> urls) {
		video.addAll(urls);
	}

	public void addNews(String... urls) {
		news.addAll(Arrays.asList(urls));
	}

	public void addNews(List<String> urls) {
		news.addAll(urls);
	}

	public void setPerson(Person p) {
		firstName = p.getFirstName();
		lastName = p.getLastName();
		email = p.getEmail();
	}

	public void addPhotos(File... photos) {
		photo.addAll(Arrays.asList(photos));
	}

	public void addPhotos(List<File> photos) {
		photo.addAll(photos);
	}

	public void addCustomFields(Map<String,String> cfs) {
		customFields.putAll(cfs);
	}
	public void addCustomField(String name, String value) {
		customFields.put(name,value);
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}
}
