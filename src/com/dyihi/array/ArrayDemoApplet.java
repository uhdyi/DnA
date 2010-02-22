package com.dyihi.array;

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class ArrayDemoApplet extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
					
					setPreferredSize(new Dimension(1000,1000));
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't complete successfully");
		}
	}
	
	private void createGUI() {
		ArrayDemoPanel contentPane =  new ArrayDemoPanel();
		contentPane.setOpaque(true);
		setContentPane(contentPane);
	}
}
