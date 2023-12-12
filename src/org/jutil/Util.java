
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
import java.text.*;
import java.util.*;

import javax.swing.*;

/**
 * General utility class with static methods, written for convenience reasons.
 */
public class Util {

	/** a date format for */
	public static final SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/** a date format for */
	public static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

	/**
	 * Deny external construction.
	 */
	private Util() {

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
	 * Convenience method for Thread.sleep(millis).<br />
	 * An InterruptedException will be ignored, the stack trace is shown on <code>System.out</code>.<br />
	 * Note: the thread calling this method will sleep. Therefore, if one calls it from
	 * the event dispatching thread, a <code>RuntimeException</code> is thrown - otherwise the GUI would freeze.
	 *
	 * @param millis				the milliseconds to sleep
	 * @param displayStackTrace		if true, in case of an <code>InterruptedException</code> during sleeping a
	 * 								stack trace is displayed on <code>System.out</code>
	 * @throws RuntimeException if the current thread is the event dispatching thread
	 */
	public static void sleep(long millis, boolean displayStackTrace) {

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
	 * Convenience method for throwing a <code>RuntimeException</code> named <code>NotImplementedException</code> 
	 * during development at places where coding has not been finished yet.
	 * 
	 * @throws RuntimeException if the current thread is the event dispatching thread
	 */
	public static void notImplementedException() {

		@SuppressWarnings("serial")
		class NotImplementedException extends RuntimeException {
			public NotImplementedException() {
				super("TODO: code is not implemented, check the stack trace");
			}
		};
		throw new NotImplementedException();
	}
}
