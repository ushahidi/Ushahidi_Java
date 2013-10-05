package com.ushahidi.java.sdk.api;

import com.google.gson.annotations.SerializedName;

public class CustomFormMeta {

	public static final int TYPE_TEXT = 1;
	public static final int TYPE_TEXTAREA = 2;
	public static final int TYPE_DATE = 3;
	public static final int TYPE_PASSWORD = 4;
	public static final int TYPE_RADIO = 5;
	public static final int TYPE_CHECKBOX = 6;
	public static final int TYPE_DROPDOWN = 7;

	@SerializedName("id")
	private int fieldId;
	private String name;
	private int type;
	@SerializedName("default")
	private String defaultValues;
	private int required;
	@SerializedName("maxlen")
	private int maxLen;
	@SerializedName("isdate")
	private int isDate;
	@SerializedName("ispublicvisible")
	private int isPublicVisible;
	@SerializedName("ispublicsubmit")
	private int isPublicSubmit;

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDefaultValues() {
		return defaultValues;
	}

	public void setDefaultValues(String defaultValues) {
		this.defaultValues = defaultValues;
	}

	public int getRequired() {
		return required;
	}

	public void setRequired(int required) {
		this.required = required;
	}

	public int getMaxLen() {
		return maxLen;
	}

	public void setMaxLen(int maxLen) {
		this.maxLen = maxLen;
	}

	public int getIsDate() {
		return isDate;
	}

	public void setIsDate(int isDate) {
		this.isDate = isDate;
	}

	public int getIsPublicVisible() {
		return isPublicVisible;
	}

	public void setIsPublicVisible(int isPublicVisible) {
		this.isPublicVisible = isPublicVisible;
	}

	public int getIsPublicSubmit() {
		return isPublicSubmit;
	}

	public void setIsPublicSubmit(int isPublicSubmit) {
		this.isPublicSubmit = isPublicSubmit;
	}

	@Override
	public String toString() {
		return "CustomFormMeta [fieldId=" + fieldId + ", name=" + name
				+ ", type=" + type + ", defaultValues=" + defaultValues
				+ ", required=" + required + ", maxLen=" + maxLen + ", isDate="
				+ isDate + ", isPublicVisible=" + isPublicVisible
				+ ", isPublicSubmit=" + isPublicSubmit + "]";
	}

}
