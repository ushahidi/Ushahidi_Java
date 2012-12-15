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

import com.google.gson.annotations.SerializedName;

/**
 * This Media class has all properties and methods of the Ushahidi API's media
 * resource
 * 
 * @author eyedol
 * 
 */
public class Media {

	private int id;

	private int type;

	private String link;

	private String thumb;

	@SerializedName("thumb_url")
	private String thumbUrl;

	@SerializedName("link_url")
	private String linkUrl;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return this.link;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getThumb() {
		return this.thumb;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getThumbUrl() {
		return this.thumbUrl;
	}

	@Override
	public String toString() {
		return "Media [id:" + id + ", type:" + type + ", link:" + link
				+ ", thumb:" + thumb + ", thumbUrl:" + thumbUrl + ", link:"
				+ linkUrl + "]";
	}
}
