
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
 * Utilities for Enum.
 * 
 * <pre>
 * Hints:
 *    
 *    enum XYZ {A, B, C};
 *    
 *    to find an enum element by it's name:   XYZ element = XYZ.valueOf("A");
 *    
 *    or using:   XYZ element = Enum.valueOf(XYZ.class, "A");
 * 
 * </pre>
 */
public class EnumUtil {

	/**
	 * Deny external construction.
	 */
	private EnumUtil() {
		
	}
	
	/**
	 * Returns an array of names of an <code>enum</code>.
	 * Note: due to the enumeration Javadoc the <code>toString()</code>
	 * method is used to get the names.
	 * 
	 * @param <E>			the enumeration
	 * @param enumClass		the class of the enumeration
	 * @return an array of names of the elements of the  enumeration
	 */
	public static <E extends Enum<E>> String[] enumNames(Class<E> enumClass) {
		
		E[] elements = enumClass.getEnumConstants();
		String[] names = new String[elements.length];
		for (int i = 0; i < elements.length; i++) {
			names[i] = elements[i].toString();			// javadoc enum hint: use toString()
		}
		return names;
	}

	/**
	 * Returns an <code>ArrayList</code> of names of an <code>enum</code>.
	 * Note: due to the enumeration Javadoc the <code>toString()</code>
	 * method is used to get the names.
	 * 
	 * @param <E>			the enumeration
	 * @param enumClass		the class of the enumeration
	 * @return the <code>ArrayList</code> of names of the elements of the  enumeration
	 */
	public static <E extends Enum<E>> ArrayList<String> enumToNameList(Class<E> enumClass) {
		
		return new ArrayList<String>(Arrays.asList(enumNames(enumClass)));
	}
}
