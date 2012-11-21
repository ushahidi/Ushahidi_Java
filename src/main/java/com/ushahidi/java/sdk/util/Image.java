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
package com.ushahidi.java.sdk.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A Utility class for downloading image from a remote server and manipulating
 * an image.
 */
public class Image {

	private static final int IO_BUFFER_SIZE = 512;

	/**
	 * Copy the content of the input stream into the output stream, using a
	 * temporary byte array buffer.
	 * 
	 * @param in
	 *            The input stream to copy from.
	 * @param out
	 *            The output stream to copy to.
	 * @throws IOException
	 *             If any error occurs during the copy.
	 */
	private static void copy(InputStream in, OutputStream out)
			throws IOException {
		byte[] b = new byte[4 * 1024];
		int read;
		while ((read = in.read(b)) != -1) {
			out.write(b, 0, read);
		}
	}

	/**
	 * Closes the specified stream.
	 * 
	 * @param stream
	 *            The stream to close.
	 */
	private static void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Open a stream to pull an image from a remote server via http
	 * 
	 * @param address
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static byte[] fetchImage(String address)
			throws MalformedURLException, IOException {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new BufferedInputStream(new URL(address).openStream(),
					IO_BUFFER_SIZE);

			final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
			out = new BufferedOutputStream(dataStream, 4 * 1024);
			copy(in, out);
			out.flush();

			// need to close stream before return statement
			closeStream(in);
			closeStream(out);

			return dataStream.toByteArray();
		} catch (IOException e) {

		} finally {
			closeStream(in);
			closeStream(out);

		}
		return null;

	}

	private static byte[] retrieveImageData(String imageUrl) throws IOException {
		return fetchImage(imageUrl);
	}

	private static void writeImage(byte[] data, String filename, String path) {

		if (data != null) {
			FileOutputStream fOut;
			try {
				fOut = new FileOutputStream(new File(path, filename), false);
				fOut.write(data);
				fOut.flush();
				fOut.close();
			} catch (final FileNotFoundException e) {

				e.printStackTrace();
			} catch (final IOException e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Dowload an image from a remote server.
	 * 
	 * @param imageUrl
	 *            The URL of the image.
	 * @param filename
	 *            The new filename.
	 * @param destination
	 *            Where to save the image. Eg. /home/user/pictures
	 */
	public static void download(String imageUrl, String filename,
			String destination) {
		try {
			byte[] imageData = retrieveImageData(imageUrl);

			// save the photo
			writeImage(imageData, filename, destination);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
