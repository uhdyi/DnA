package com.dyihi.array;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ArrayDemoPanel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String CREATE_COMMAND = "Create";
	private static String INSERT_COMMAND = "Insert";
	private static String SEARCH_COMMAND = "Search";
    private static String REMOVE_COMMAND = "Remove";
    private static String CLEAR_COMMAND = "Clear";
    
	private JTextField inputText;
	private ArrayPanel arrayPanel;
	
	public ArrayDemoPanel() {
		super(new BorderLayout());
				
		arrayPanel = new ArrayPanel();
		JScrollPane container = new JScrollPane(arrayPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		add(container, BorderLayout.CENTER);
		
		JButton createButton = new JButton("Create Array");	
		createButton.addActionListener(this);
		createButton.setActionCommand(CREATE_COMMAND);
		
		JButton insertButton = new JButton("Insert");
		insertButton.addActionListener(this);
		insertButton.setActionCommand(INSERT_COMMAND);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		searchButton.setActionCommand(SEARCH_COMMAND);
		
		JButton removeButton = new JButton("Remove");		
		removeButton.addActionListener(this);
		removeButton.setActionCommand(REMOVE_COMMAND);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setActionCommand(CLEAR_COMMAND);
		
		inputText = new JTextField(20);
		
		JPanel panel = new JPanel(new GridLayout(1, 4));
		panel.add(createButton);
		panel.add(insertButton);
		panel.add(removeButton);
		panel.add(clearButton);
		panel.add(inputText);
		add(panel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals(CREATE_COMMAND)) {
			arrayPanel.create(inputText.getText());
		} else if (command.equals(INSERT_COMMAND)) {
			arrayPanel.insert(inputText.getText());			
		} else if (command.equals(SEARCH_COMMAND)) {
			arrayPanel.search(inputText.getText());
		} else if (command.equals(REMOVE_COMMAND)) {
			arrayPanel.remove(inputText.getText());
		} else if (command.equals(CLEAR_COMMAND)) {
			arrayPanel.clear();
		} else {
			// do nothing
		}
	}
	/**	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayDemoPanel demoPanel = new ArrayDemoPanel();
		demoPanel.setOpaque(true);
		frame.setContentPane(demoPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
    // called when run as an application

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }	
    */
}
