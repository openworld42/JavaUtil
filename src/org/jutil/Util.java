
/**
 * Copyright 2023 Heinz Silberbauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     https://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jutil;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

/**
 * General utility class with static methods, written for convenience reasons.
 */
public class Util {

	public static final SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

	/**
	 * Deny external construction.
	 */
	private Util() {

	}

	/**
	 * Blocks the current thread until a message dialog is confirmed.
	 * Uses SwingUtilities.invokeAndWait() and JOptionPane.showMessageDialog() to do this.
	 *
	 * @param message			the message
	 * @param title				the title of the dialog
	 * @param messageType		the message type of the dialog (e.g. <code>JOptionPane.INFORMATION_MESSAGE</code>)
	 * @throws RuntimeException if called on the event dispatch thread
	 */
	public static void blockingConfirmDlg(final String message, final String title, int messageType) {

		if (SwingUtilities.isEventDispatchThread()) {
			throw new RuntimeException("Do not call this method from the event dispatch thread!");
		}
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					JOptionPane.showMessageDialog(null, message, title, messageType);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a date and time stamp (without milliseconds) as a <code>String</code>,
	 * like "yyyy-MM-dd HH:mm:ss".
	 * 
	 * @return the date and time stamp string
	 */
	public static String createDateAndTimeStamp() {
	
		return DATE_FORMAT1.format(new Date());
	}

	/**
	 * Creates a time stamp (without milliseconds, without date) as a <code>String</code>, 
	 * like "HH:mm:ss".
	 * 
	 * @return the time stamp string
	 */
	public static String createTimeStamp() {
	
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(new Date());
	}

	/**
	 * Returns a space separated String of all integer elements of an ArrayList.

	 * @param ids		the ArrayList<Integer>
	 * @return the string
	 */
	public static String idListToString(ArrayList<Integer> ids) {

		if (ids.size() == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer("" + ids.get(0));
		for (int i = 1; i < ids.size(); i++) {
			sb.append(" ");
			sb.append(ids.get(i));
		}
		return sb.toString();
	}

	/**
     * Prompts for a text message in the <i>System.out</i> window, blocks until the user
     * types <i>RETURN/ENTER</i> and returns the string typed in.
     * This method intentionally encapsulates possible exceptions.
     *
     * @param text the text string to be displayed
     * @return a String containing the input
	 */
	public static String prompt(String text) {

		BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream sysOut = new DataOutputStream(System.out);
        String s = null;
		try {
			sysOut.writeBytes(text);
			sysOut.flush();
            s = sysIn.readLine();
			// do not close System.out or System.in!
		}
		catch (Exception e) {
			System.out.println("\nError in Util.prompt()!");
			e.printStackTrace();
		}
		return s;
	}
    
    /**
     * Reads the content of an URL into a String object.<br />
     * Note: this is a very simple wget.
     * 
     * @param url				the URL to read from
     * @return the content of the URL
     * @throws Exception in case of unexpected exceptions
     */
    public static String readFromUrl(String url) throws Exception {
        
        URL resLocator = new URL(url);
        URLConnection connection = resLocator.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = in.readLine();
        while (line != null) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }

	/**
	 * Renames a file to a backup file, if the file exists .
	 * If an old backup file exists already, it is deleted before renaming the file.
	 * 
	 * @param fileName				the name of the file to be the backup file
	 * @param backupFileName		the name of backup file
	 * @throws IOException in case of unexpected exceptions or write/delete errors
	 */
	public static void renameToBackupFile(String fileName, String backupFileName) throws IOException {

		File file = new File(fileName);
		File backupFile = new File(backupFileName);
		if (!file.exists()) {
			return;
		}
		if (!file.canWrite()) {
			throw new IOException("Cannot write to file " + fileName);
		}
		if (backupFile.exists()) {
			if (!backupFile.delete()) {
				throw new IOException("Cannot delete file " + backupFileName);
			}
			backupFile.delete();
		}
		file.renameTo(backupFile);
	}
	
	/**
	 * Convenience method for Thread.sleep(millis).<br />
	 * An InterruptedException will be ignored, the stack trace is shown on <code>System.out</code>.<br />
	 * Note: the thread calling this method will sleep. Therefore, if one calls it from
	 * the event dispatching thread, a <code>RuntimeException</code> is thrown - otherwise the GUI would freeze.
	 *
	 * @param millis	the milliseconds to sleep
	 * @throws RuntimeException if the current thread is the event dispatching thread
	 */
	public static void sleep(long millis) {

		if (SwingUtilities.isEventDispatchThread()) {
			throw new RuntimeException("Do not call this method from the event dispatching thread!");
		}
		try {
			Thread.sleep(millis);		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Convenience method for Thread.sleep(millis).<br />
	 * An InterruptedException will be ignored, the stack trace is shown on <code>System.out</code>.<br />
	 * Note: the thread calling this method will sleep. Therefore, if one calls it from
	 * the event dispatching thread, a <code>RuntimeException</code> is thrown - cause the GUI would freeze.
	 *
	 * @param millis	the milliseconds to sleep
	 * @throws RuntimeException if the current thread is the event dispatching thread
	 */
	public static void notImplementedException() {

		class NotImplementedException extends RuntimeException {
			public NotImplementedException() {
				super("TODO: code is not implemented, check the stack trace");
			}
		};
		throw new NotImplementedException();
	}

	/**
	 * Writes the content of a String object to a file.
	 * 
	 * @param fileName
	 * @param content
	 * @throws IOException
	 */
	public static void writeFile(String fileName, String content) throws IOException {

		BufferedWriter writer = null;
		try {
		   writer = new BufferedWriter(new FileWriter(fileName));
		   writer.write(content);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
