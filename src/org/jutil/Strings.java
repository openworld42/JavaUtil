
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

import java.util.*;

/**
 * A compilation of various String utilities.<br />
 * Some methods support parsing. There are also a lot of string handling, parsing, 
 * searching, replacing methods in various regular Java classes.
 */
public class Strings {

	/**
	 * Deny external construction.
	 */
	private Strings() {

	}
	
    /**
     * Returns a centered string with borders to the left and right (if any).
     * Any space between the border strings is filled with spaces.
     * If the length is choosen too short, the result is a concatenation of 
     * the borders with the string in it.
      * <pre>
     * Examples:
     * 
     * 		Strings.center("***", "text", "***", 16);		// returns "***   text   ***"
     * 
     * 		System.out.println(Strings.repeat(30, "*"));
     * 		System.out.println(Strings.center("***", "headline", "***", 30));
     * 		System.out.println(Strings.repeat(30, "*"));	// prints on System.out:
     * 
     * 		******************************
     * 		***        headline        ***
     * 		******************************
     * </pre>
     * 
     * @param leftBorder		the left side border string, may be null
     * @param string			the string to be centered, may be null
     * @param rightBorder		the right side border string, may be null
     * @param length			the length of the resulting string
     */
    public static String center(String leftBorder, String string, String rightBorder, int length) {
    	
    	leftBorder = leftBorder == null ? "" : leftBorder;
       	rightBorder = rightBorder == null ? "" : leftBorder;
       	string = string == null ? "" : string;
    	StringBuilder sb = new StringBuilder(leftBorder);
    	// if odd, the right side is on blank longer then the left side
    	int half = (length - string.length()) / 2;	
    	for (int i = leftBorder.length(); i < half; i++) {
			sb.append(" ");
		}
		sb.append(string);
    	for (int i = half + string.length(); i < length - rightBorder.length(); i++) {
			sb.append(" ");
		}
		sb.append(rightBorder);
    	return sb.toString();
    }

    /**
     * Fill a filler into the left side of a string until a maximum length is reached.
     * <pre>
     * Examples:
     * 
     * 		Strings.fillLeft(null, 5, "*");				// returns "*****"
     * 		Strings.fillLeft(" text", 8, "*");			// returns "*** text"
     * 		Strings.fillLeft("" + i + ": ", 7, " ");	// returns "   42: " if i is 42 (note: useful for line numbers)
     * 		Strings.fillLeft("text", 2, "*");			// returns "text"
     * 		Strings.fillLeft(" text", 12, "abc");		// returns "abcabca text"
     * 		Strings.fillLeft(" text", 7, "abc");		// returns "ab text"
     * </pre>
     * 
     * @param origin			the origin string, may be null or empty
     * @param maxLength			the length of the filled in result	
     * @param filler			a string to fill in (may also be " " to fill with spaces)
     * @return the resulting string or the origin if its length is greater or 
     * 		equal than <code>maxLength</code>
     * @throws IllegalArgumentException if <code>filler</code> is <code>null</code> or empty ("")
     */
    public static String fillLeft(String origin, int maxLength, String filler) throws IllegalArgumentException {
    	
    	String s = origin != null ? origin : "";
    	int length = s.length();
    	if (length >= maxLength) {
			return s;
		}
    	if (filler == null || filler.length() == 0) {
			throw new IllegalArgumentException("Filler cannot be null or empty");
		}
    	return fillRight(null, maxLength - s.length(), filler) + s;
    }

    /**
     * Fill a filler into the right side of a string until a maximum length is reached.
     * <pre>
     * Examples:
     * 
     * 		Strings.fillRight(null, 5, "*");			// returns "*****"
     * 		Strings.fillRight("text  ", 8, "*");		// returns "text  **"
     * 		Strings.fillRight("" + i + ": ", 7, " ");	// returns "42:    " if i is 42
     * 		Strings.fillRight("text", 2, "*");			// returns "text"
     * 		Strings.fillRight("text  ", 13, "abc");		// returns "text  abcabca"
     * 		Strings.fillRight("text  ", 8, "abc");		// returns "text  ab"
     * </pre>
     * 
     * @param origin			the origin string, may be null or empty
     * @param maxLength			the length of the filled in result	
     * @param filler			a string to fill in (may also be " " to fill with spaces)
     * @return the resulting string or the origin if its length is greater or 
     * 		equal than <code>maxLength</code>
     * @throws IllegalArgumentException if <code>filler</code> is <code>null</code> or empty ("")
     */
    public static String fillRight(String origin, int maxLength, String filler) throws IllegalArgumentException {
    	
    	String s = origin != null ? origin : "";
    	int length = s.length();
    	if (length >= maxLength) {
			return s;
		}
    	if (filler == null || filler.length() == 0) {
			throw new IllegalArgumentException("Filler cannot be null or empty");
		}
    	StringBuilder sb = new StringBuilder(s);
    	int fillerIndex = 0;
    	int fillerLength = filler.length();
    	for (int i = length; i < maxLength; i++) {
			sb.append(filler.charAt(fillerIndex++));
			if (fillerIndex >= fillerLength) {
				fillerIndex = 0;
			}
		}
    	return sb.toString();
    }
	
    /**
     * Returns an indented string, where the prefix is cancatenated by <code>indentLevel</code> times
     * the <code>indentation</code> parameter.<br />
     * Example: <code>indentation</code> of "  " (two spaces) and an <code>indentLevel</code> of three
     * will put six spaces before the string.
     * 
     * @param indentation			the indentation string, may be null
     * @param indentLevel			the level of the indentation
     * @param string				the string to be indented
     * @return the indented string
     */
    public static String indent(String indentation, int indentLevel, String string) {
    	
    	if (indentation == null || indentLevel < 1) {
			return string;
		}
      	StringBuilder sb = new StringBuilder();
      	for (int i = 0; i < indentLevel; i++) {
			sb.append(indentation);
		}
      	sb.append(string);
    	return sb.toString();
    }
    
    /**
     * Returns a string from a list, whereby each item of the list is concatenated with fillers 
     * to the right and to the left. A flag controls if the last element should have a filler to the right.
     * <pre>
     * Examples:
     * 
     * 		Strings.listToString(List.of(1, 2, 3), "   ", ",\n", false);	
     * 		// returns (indented by "   "):
     * 		   1,
     * 		   2,
     * 		   3
     * 
     * 		Strings.listToString(List.of(1, 2, 3), null, ",", false);		
     * 		// returns "1,2,3"
     * 
     * 		Strings.listToString(List.of("This", "is", "a", "text."), null, " <-\n", true); 
     * 		// returns:
     * 		This <-
     * 		is <-
     * 		a <-
     * 		text. <-
     * </pre>
     * 
     * @param <T>					generic type parameter for the elements of the <code>List</code>
     * @param list					the <code>List</code> containing the elements
     * @param fillerLeft			a filler string added before each element, may be null
     * @param fillerRight			a filler string added after each element, may be null
     * @param addLastRightFiller	if false, no <code>fillerRight</code> is added for the last element
     * @return the resulting string
     */
    public static <T> String listToString(List<T> list, String fillerLeft, 
    		String fillerRight, boolean addLastRightFiller) {
    	
    	StringBuilder sb = new StringBuilder();
    	fillerLeft = fillerLeft == null ? "" : fillerLeft;
    	fillerRight = fillerRight == null ? "" : fillerRight;
    	for (int i = 0; i < list.size() - 1; i++) {
    		sb.append(fillerLeft);
    		sb.append(list.get(i).toString()).append(fillerRight);
		}
    	sb.append(fillerLeft).append(list.get(list.size() - 1).toString());
    	if (addLastRightFiller) {
			sb.append(fillerRight);
		}
    	return sb.toString();
    }
	
    /**
     * Returns a string repeated characters or string characters until a maximum length is reached.<br />
     * Note: this is a convenience method, <code>fillLeft()</code> or <code>fillRight()</code> can do the same.
     * <pre>
     * Examples:
     * 
     * 		Strings.repeat(5, "*");					// returns "*****"
     * 		Strings.repeat(5, "abc");				// returns "abcab"
     * 		Strings.repeat(3, "abcde");				// returns "abc"
     * </pre>
     * 
     * @param length				the length of the resulting string
     * @param repetition			a string or single character string (e.g. " ") to be repeated
     * @return the resulting string
     * @throws IllegalArgumentException if <code>filler</code> is <code>null</code> or empty ("")
     */
    public static String repeat(int length, String repetition) throws IllegalArgumentException {
    	
    	return fillRight(null, length, repetition);
    }
	
	/**
	 * Returns a string stripped-down by an ending or the string itself if it has
	 * another ending.<br />
	 * 
	 * <pre>
	 * Examples:
	 * 
	 * Strings.stripIfEndsWith("myFile.json", ".json"); // returns "myFile"
	 * Strings.stripIfEndsWith("myFile.json", ".xml"); // returns "myFile.json"
	 * </pre>
	 * 
	 * @param string     the string with a possible ending
	 * @param tailToTest a string to test at the end
	 * @return the string or a string
	 */
	public static String stripIfEndsWith(String string, String tailToTest) {

		if (string.endsWith(tailToTest)) {
			return string.substring(0, string.length() - tailToTest.length());
		}
		return string;
	}
	
    /**
     * Returns a string stripped-down at the beginning or the string itself if it has another beginning.<br />
     * <pre>
     * Examples:
     * 
     * 		Strings.stripIfStartsWith("myFile.json", "my");		// returns "File.json"
     * 		Strings.stripIfStartsWith("myFile.json", "xy");		// returns "myFile.json"
     * </pre>
     * 
     * @param string				the string with a possible ending
     * @param tailToTest			a string to test at the end
     * @return the string or a string 
     */
    public static String stripIfStartsWith(String string, String beginningToTest) {
    	
    	if (string.startsWith(beginningToTest)) {
			return string.substring(beginningToTest.length());
		}
    	return string;
    }
    
    /**
     * Wraps a (long) string after given delimiter characters, depending of <code>wrapColumn</code>.<br />
     * This is done by inserting newline characters into the resulting string.
     * Each wrapped line contains at least one character/string which is not a delimiter.<br />
     * Note: <code>wrapColumn()</code> uses <code>StringTokenizer</code> for a much simpler
     * behavior than using regular expressions, otherwise the caller would need much more effort and testing. 
     * 
     * <pre>
     * Examples:
     * 
     * 		Strings.wrapByColumn("a,b,c d", ", ", true, 0);   // returns "a,\nb,\nc \nd"
     * 		a,
     * 		b,
     * 		c
     * 		d
     * 
     * 		Strings.wrapByColumn("[1,2,3]", "[],", false, 0);  // returns "1\n2\n3"
     * 		1
     * 		2
     * 		3
     * 
     * 		Strings.wrapByColumn("[1,2,33]", ",", true, -3);  // returns "[1,\n2,\n33]"
     * 
     * 		Strings.wrapByColumn("[1,2,3,4]", ",", true, 4);  // returns "[1,2,\n3,4]"
     * </pre>
     * 
     * @param string			the string to wrap
     * @param delimiters		a string of one or more delimiting characters, similar 
     * 							to <code>StringTokenizer</code>
     * @param returnDelims		if false, the delimiters are not contained in the resulting string
     * @param wrapColumn		if zero, wrapping happens on each parsed delimiter. If negative,
     * 							wrapping happens always <i>before or at</i> wrapColumn is reached, but in
     * 							any case after at least after one delimiter. If positive, wrapping happens
     * 							<i>at or after</i> wrapColumn is reached.
     * @return the (possibly) wrapped string
     */
    public static String wrapByColumn(String string, String delimiters, boolean returnDelims, int wrapColumn) {
    	
       	if (wrapColumn == 0) {
       		return wrapToString(string, delimiters, returnDelims);
		}
    	List<String> list = wrapToList(string, delimiters, returnDelims);
       	StringBuilder sb = new StringBuilder();
       	int length = 0;
       	if (wrapColumn > 0) {
       		for (int i = 0; i < list.size(); i++) {
       			String str = list.get(i);
           		sb.append(str);
           		length += str.length();
           		if (length >= wrapColumn && i != list.size() - 1) {
           			sb.append('\n');
           			length = 0;
				}
			}
       		return sb.toString();
       	}
       	// wrapColumn < 0
       	wrapColumn = -wrapColumn;
   		for (int i = 0; i < list.size(); i++) {
   			String str = list.get(i);
       		if (length > 0 && length + str.length() > wrapColumn) {
       			sb.append('\n');
       			length = 0;
			}
       		sb.append(str);
       		length += str.length();
		}
     	return sb.toString();
    }

    /**
     * Wraps a (long) string after given delimiter characters.<br />
     * This is done by adding each wrapped string to an <code>ArrayList</code>, not adding a newline.
     * Each wrapped line contains at least one character/string which is not a delimiter.<br />
     * Note: <code>wrapToList()</code> uses <code>StringTokenizer</code> for a much simpler
     * behavior than using regular expressions, otherwise the caller would need much more effort and testing. 
     * 
     * <pre>
     * Examples:
     * 
     * 		Strings.wrapToList("a,b,c d", ", ", true);   
     * 		// returns {"a,", "b,", "c ", "d"}
     * 
     * 		Strings.wrapToList("[1,2,3]", "[],", false);
     * 		// returns {"1", "2", "3"}
     * 
     * 		Strings.wrapToList("[1,2,33]", ",", true);
     * 		// returns {"[1,", "2,", "33]"}
     * </pre>
     * 
     * @param string			the string to wrap
     * @param delimiters		a string of one or more delimiting characters, similar 
     * 							to <code>StringTokenizer</code>
     * @param returnDelims		if false, the delimiters are not contained in the resulting string
     * @return the <code>List</code> of strings
     */
    public static List<String> wrapToList(String string, String delimiters, boolean returnDelims) {
    	
    	StringTokenizer st = new StringTokenizer(string, delimiters, true);
    	ArrayList<String> list = new ArrayList<>();
    	String last = "";
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.length() == 1 && delimiters.indexOf(str) >= 0) {
				// it is a delimiter
            	if (returnDelims) {
					list.add(last + str);
				} else {
					if (!last.equals("")) {
						list.add(last);
					}
				}
				last = "";
			} else {
				// not a delimiter, but may have the length of one
				last = str;
			}
        }
        if (!"".equals(last)) {
        	// the last one was not added
			list.add(last);
		}
    	return list;
    }

    /**
     * Wraps a (long) string after given delimiter characters.<br />
     * This is done by adding each wrapped string to an <code>ArrayList</code>, not adding a newline.
     * Each wrapped line contains at least one character/string which is not a delimiter.<br />
     * Note: <code>wrapToList()</code> uses <code>StringTokenizer</code> for a much simpler
     * behavior than using regular expressions, otherwise the caller would need much more effort and testing. 
     * 
     * <pre>
     * Examples:
     * 
     * 		Strings.wrapToList("a,b,c d", ", ", true, 3);   
     * 		// returns {"a,b,c ", "d"}
     * 
     * 		Strings.wrapToList("[1,2,3]", "[],", false, 1);
     * 		// returns {"1", "2", "3"}
     * 
     * 		Strings.wrapToList("[1,2,33]", ",", true, 2);
     * 		// returns {"[1,2,", "33]"}
     * </pre>
     * 
     * @param string			the string to wrap
     * @param delimiters		a string of one or more delimiting characters, similar 
     * 							to <code>StringTokenizer</code>
     * @param returnDelims		if false, the delimiters are not contained in the resulting string
     * @param count				the maximum number of parsed items with delimiters of a list element
     * @return the <code>List</code> of strings
     */
    public static List<String> wrapToList(String string, String delimiters, boolean returnDelims, int count) {
    	
    	List<String> list = wrapToList(string, delimiters, returnDelims);
     	ArrayList<String> wrappedList = new ArrayList<>();
     	int wrapCount = 0;
       	StringBuilder sb = new StringBuilder();
       	for (String element : list) {
       		sb.append(element);
       		wrapCount++;
       		if (wrapCount == count) {
       			wrappedList.add(sb.toString());
       			sb = new StringBuilder();
       			wrapCount = 0;
			}
		}
       	if (wrapCount > 0) {
        	// the last one was not added
   			wrappedList.add(sb.toString());
		}
       	return wrappedList;
    }

    /**
     * Wraps a (long) string after given delimiter characters.<br />
     * This is done by inserting newline characters into the resulting string.
     * Each wrapped line contains at least one character/string which is not a delimiter.<br />
     * Note: <code>wrapToString()</code> uses <code>StringTokenizer</code> for a much simpler
     * behavior than using regular expressions, otherwise the caller would need much more effort and testing. 
     * 
     * <pre>
     * Examples:
     * 
     * 		Strings.wrapToString("a,b,c d", ", ", true);   // returns "a,\nb,\nc \nd"
     * 		a,
     * 		b,
     * 		c
     * 		d
     * 
     * 		Strings.wrapToString("[1,2,3]", "[],", false);  // returns "1\n2\n3"
     * 		1
     * 		2
     * 		3
     * 
     * 		Strings.wrapToString("[1,2,33]", ",", true);  // returns "[1,\n2,\n33]"
     * </pre>
     * 
     * @param string			the string to wrap
     * @param delimiters		a string of one or more delimiting characters, similar 
     * 							to <code>StringTokenizer</code>
     * @param returnDelims		if false, the delimiters are not contained in the resulting string
     * @return the (possibly) wrapped string
     */
    public static String wrapToString(String string, String delimiters, boolean returnDelims) {
    	
    	List<String> list = wrapToList(string, delimiters, returnDelims);
       	StringBuilder sb = new StringBuilder();
       	for (int i = 0; i < list.size() - 1; i++) {
       		sb.append(list.get(i)).append('\n');
		}
       sb.append(list.get(list.size() - 1));
    	return sb.toString();
    }
}
