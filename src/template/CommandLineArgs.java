
/**
 * Copyright 2020 Heinz Silberbauer
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
package template;

/**
 * Command line parser and option container for the program.
 */
public class CommandLineArgs {


	/** flag if all of the command line arguments are valid */
	private boolean isValid;
	/** the current index of the command line argument */
	private int cliIndex;
	/** flag if there will be verbose messages */
	private boolean isVerbose = true;
	/** example for an option T */
	private boolean hasTOption;		// TODO implement getter for the options you define, if needed
	/** an URL */
	private String url;

	/**
	 * Construct CommandLineArgs using the command line arguments.
	 * 
	 * @param args 		 		the arguments of the application
	 */
	public CommandLineArgs(String[] args) {

//	    System.out.println("Argument count: " + args.length);
		
//		-t -url www.xy
		
//        if (args.length < 3) {		// TODO  minimum argument check
//        	isValid = false;
//        	return;
//        }
	    for (cliIndex = 0; cliIndex < args.length; cliIndex++) {
	    	
//	        System.out.println("Argument " + cliIndex + ": " + args[cliIndex]);
	    	
            if (args[cliIndex].equals("-h")) {
                Usage.exit(0);
            } else if (args[cliIndex].equals("-v")) {
            	Version.print();
            	System.exit(0);
            } else if (args[cliIndex].equals("-q")) {
            	// qiet option
            	isVerbose = false;
            } else if (args[cliIndex].equals("-t")) {
            	// simple option
            	hasTOption = true;
            } else if (args[cliIndex].equals("-url")) {
            	// needs one additional parameter (the URL)
            	if (args.length - cliIndex < 2) {
                   	isValid = false;
                	return;
				}
            	url = args[++cliIndex];
            } else {
            	// not a valid option
            	isValid = false;
            	return;
            }
	    }
	    
	    // checks for incompatibility
//	    if (hasTOption && url != null) {		// TODO  
//        	isValid = false;
//        	return;
//		}
	    
		isValid = true;
	}

	/**
	 * @return true if the command line parsing had no errors and incompatibilities, false otherwise
	 */
	public boolean isValid() {
		
		return isValid;
	}

	/**
	 * Flag for verbose messages to System.out.
	 * 
	 * @return the isVerbose
	 */
	public boolean isVerbose() {
		
		return isVerbose;
	}
}
