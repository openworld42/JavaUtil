
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
package org.jutil.system;

import java.io.*;
import java.util.*;

/**
 * An executor to process operation system (shell) commands.<br/>
 * After execution an exit code or the output can be requested.<br/>
 * The call is OS dependent (examples):
 * <pre>
 * 		Linux, Unix, MacOS, others:
 * 
 * 			CommandExecutor executor = new CommandExecutor("bash", "-c", "ls -la");
 * 			
 * 		MS-Windows:
 * 
 * 			CommandExecutor executor = new CommandExecutor("cmd.exe", "/c", "ping -n 3 localhost");
 * </pre>
 * Get the exit code and output:
 * <pre>
 * 				System.out.println("Exit code: " + executor.getExitCode());
 *				System.out.println("Output:\n" + executor.getOutput());
 * </pre>
 */
public class CommandExecutor {
	
	/** the exit code after execution of the command */
	private int exitCode;
	/** the output after the execution of the command */
	private String output;
	/** the output as lines after the execution of the command */
	private ArrayList<String> lines;
	
	/**
	 * Construction of the executor.<br/>
	 * This call is OS dependent (examples):
	 * <pre>
	 * 		Linux, Unix, MacOS, others:
	 * 
	 * 			CommandExecutor executor = new CommandExecutor("bash", "-c", "ls -la");
	 * 			
	 * 		MS-Windows:
	 * 
	 * 			CommandExecutor executor = new CommandExecutor("cmd.exe", "/c", "ping -n 3 localhost");
	 * </pre>
	 * 
	 * @param cmdAndParameters		the shell, options and the command to execute
	 * @param cmdAndParameters
	 * @throws IOException in case of IO errors
	 * @throws InterruptedException if the process has been interrupted
	 */
	public CommandExecutor(String... cmdAndParameters) throws IOException, InterruptedException{

		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command(cmdAndParameters);
		Process process = processBuilder.start();
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		lines = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			lines.add(line);
			sb.append(line + "\n");
		}
		output = sb.toString();
		exitCode = process.waitFor();
	}
	
	/**
	 * Returns the exit code.
	 * 
	 * @return the exit code
	 */
	public int getExitCode() {
		
		return exitCode;
	}

	/**
	 * Returns the output as lines, without a newlines.
	 * 
	 * @return the output lines as an array
	 */
	public ArrayList<String> getLines() {
		
		return lines;
	}

	/**
	 * Returns the output.
	 * 
	 * @return the output
	 */
	public String getOutput() {
		
		return output;
	}
}
