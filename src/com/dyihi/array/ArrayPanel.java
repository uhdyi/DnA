package com.dyihi.array;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ArrayPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int CELL_WIDTH = 40;
	private static int CELL_HEIGHT = 40;
	private static int OFFSET = CELL_WIDTH / 2;
	
	int cellCountX;
	int cellCountY;
	
	private Array arr;
	private String note = new String();
	
	public ArrayPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	
		arr = new Array(10);
		note = "Default array size = 10";
		
		setPreferredSize(new Dimension(CELL_WIDTH * 15, CELL_HEIGHT * 5));
	}
	
	public void create(String number) {
		
		try {
			arr = new Array(Integer.parseInt(number));
			note = "Create array with size = " + number;
			
			setPreferredSize(new Dimension(CELL_WIDTH * ((Integer.parseInt(number) + 5)), CELL_HEIGHT * 5));
		} catch (NumberFormatException e) {
			note = "Input is illegal.";
		}
		
		repaint();
		revalidate();
	}
	
	public void insert(String number) {
		try {
			if(arr.insertElement(Integer.parseInt(number))) {
				note = "Insert " + number;
			} else {
				note = "Insert failed, array is full.";
			}
		} catch (NumberFormatException e) {
			note = "Input is illegal.";
		}
		
		repaint();
		revalidate();
	}
	
	public void  search(String number) {
		
	}
	
	public void remove(String number) {
		try {
			if(arr.removeElement(Integer.parseInt(number))) {
				note = "Remove " + number;
			} else {
				note = "Remove failed, " + number + " is not found.";
			}
		} catch(NumberFormatException e) {
			note = "Input is illegal.";
		}
		repaint();
		revalidate();
	}
	
	public void clear() {
		arr.clear();
		note = "Clear the array.";
		
		repaint();
		revalidate();
	}
	
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);       
        Graphics2D g2;
        g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        Font font = new Font("Serif", Font.BOLD, 16);
        g2.setFont(font);
        g2.drawString(note, 20, 20);
        
        int xPos = 50, yPos = 50;
        int width = CELL_WIDTH, height = CELL_HEIGHT;
        
        font = new Font("Serif", Font.BOLD, 12);
        for(int i = 0; i < arr.getSize(); i++) {
			int element = arr.getElement(i);
			
			g2.setColor(Color.BLUE);
			g2.drawString(Integer.toString(element), xPos + OFFSET - 5, yPos + OFFSET + 5);
			
			g2.setColor(Color.BLACK);
			g2.drawRect(xPos, yPos, width, height);
			
			xPos += width;
		}
    }
    
    
}
