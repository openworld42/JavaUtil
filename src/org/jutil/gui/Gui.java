
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
package org.jutil.gui;

import java.awt.*;

import javax.swing.*;

/**
 * Utility class for the GUI (Graphical User Interface), supporting a project's GUI with several static methods.
 */
public class Gui {
	
	/**
	 * Deny external construction.
	 */
	private Gui() {

	}

	/**
	 * Blocks the current thread until a information message dialog is confirmed.
	 * Uses SwingUtilities.invokeAndWait() and JOptionPane.showMessageDialog() to do this.
	 *
	 * @param message		the message
	 * @param title			the title of the dialog
	 * @throws RuntimeException if called on the event dispatch thread
	 */
	public static void blockingConfirmDlg(final String message, final String title) {

		if (SwingUtilities.isEventDispatchThread()) {
			throw new RuntimeException("Do not call this method from the event dispatch thread!");
		}
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Blocks the current thread until a message dialog is confirmed.
	 * Uses SwingUtilities.invokeAndWait() and JOptionPane.showMessageDialog() to do this.
	 *
	 * @param message		the message
	 * @param title			the title of the dialog
	 * @param messageType	the messageType (e.g. JOptionPane.ERROR_MESSAGE)
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
     * Centers a window (JFrame, JDialog, etc.) on the screen.
     *
     * @param window 		the window object to center
	 */
	public static void center(Window window) {

		Dimension screenSize = window.getToolkit().getScreenSize();
		Dimension windowSize = window.getSize();
		screenSize.width -= windowSize.width;
		screenSize.height -= windowSize.height;
		window.setLocation(screenSize.width / 2, screenSize.height / 2);
	}
	
	/**
	 * Enable/disable all components of a container recursively.
	 * 
	 * @param container		the container of the components to enable or disable
	 * @param enable		true to enable all components, false otherwise
	 */
	public static void enableComponents(Container container, boolean enable) {

		Component[] components = container.getComponents();
		for (Component component: components) {
			component.setEnabled(enable);
			if (component instanceof Container) {
				enableComponents((Container) component, enable);
			}
		}
	}
	
	/**
	 * Convenience method (short name): show an error dialog.
	 * 
	 * @param parent		the parent component ro null
	 * @param message		the message
	 * @param title			the title
	 */
	public static void errorDlg(Component parent, String message, String title) {
		
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Convenience method (short name): show an info dialog.
	 * 
	 * @param parent		the parent component
	 * @param message		the message
	 * @param title			the title
	 */
	public static void infoDlg(Component parent, String message, String title) {
		
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Convenience method (short name): show a warning dialog.
	 * 
	 * @param parent		the parent component
	 * @param message		the message
	 * @param title			the 
	 */
	public static void warnDlg(Component parent, String message, String title) {
		
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
	}
}
