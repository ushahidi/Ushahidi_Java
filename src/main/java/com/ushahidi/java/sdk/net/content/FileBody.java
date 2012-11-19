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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Encapsulates the file to be uploaded
 */
public class FileBody {

	private File file;

	private final String filename;

	private final String charset;

	/**
	 * Default constructor
	 * 
	 * @param file
	 *            the file to be uploaded
	 * @param filename
	 *            the name of the file
	 * @param mimeType
	 *            the mimeType
	 * @param charset
	 *            the character set
	 */
	public FileBody(final File file, final String filename,
			final String mimeType, final String charset) {

		if (file == null) {
			throw new IllegalArgumentException("File may not be null");
		}
		this.file = file;
		if (filename != null) {
			this.filename = filename;
		} else {
			this.filename = file.getName();
		}
		this.charset = charset;
	}

	/**
	 * 
	 * 
	 * @param file
	 *            the file to be uploaded
	 * @param mimeType
	 *            the mimeType
	 * @param charset
	 *            the character set
	 */
	public FileBody(final File file, final String mimeType, final String charset) {
		this(file, null, mimeType, charset);
	}

	/**
	 * 
	 * @param file
	 *            the file to be uploaded
	 * @param mimeType
	 *            the mime type
	 */
	public FileBody(final File file, final String mimeType) {
		this(file, mimeType, null);
	}

	/**
	 * @param file
	 *            The file to be uploaded
	 */
	public FileBody(final File file) {
		this(file, "application/octet-stream");
	}

	/**
	 * Get the file
	 * 
	 * @return The inputStream
	 * @throws IOException
	 */
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(this.file);
	}

	public void writeTo(final BufferedOutputStream out) throws IOException {
		if (out == null) {
			throw new IllegalArgumentException("Output stream may not be null");
		}
		InputStream in = new FileInputStream(this.file);
		try {
			byte[] buffer = new byte[8192];
			int read;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			in.close();
		} finally {
			in.close();
		}
	}

	public String getCharset() {
		return charset;
	}

	public long getContentLength() {
		return this.file.length();
	}

	public String getFilename() {
		return filename;
	}

	public File getFile() {
		return this.file;
	}
}
