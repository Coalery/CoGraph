package org.coalery;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CoGraph extends JPanel {
	
	private List<String> contents; // or item? ( variable name )
	private List<Integer> values;
	
	private int graphMargin = 50;
	private int graphBarWidth = 10;
	
	public CoGraph(String[] contents, Integer[] values) {
		this(Arrays.asList(contents), Arrays.asList(values));
	}
	
	public CoGraph(List<String> contents, List<Integer> values) { // if contents length != values length; then process idx 0 ~ min(contents length, values length)
		this.contents = contents;
		this.values = values;
	}
	
	public List<String> getContents() { return contents; }
	public List<Integer> getValues() { return values; }
	
	public void setContents(List<String> contents) { this.contents = contents; }
	public void setValues(List<Integer> values) { this.values = values; }
	
	public String getContentAt(int index) { return contents.get(index); }
	public Integer getValueAt(int index) { return values.get(index); }
	
	public void setContentAt(int index, String content) { contents.set(index, content); }
	public void setValueAt(int index, Integer value) { values.set(index, value); }
	
	public Integer getValueByContentName(String contentName) { return contents.indexOf(contentName); }
	public void setValueByContentName(String contentName, int value) {
		int targetIndex = getValueByContentName(contentName);
		if(targetIndex != -1) setValueAt(targetIndex, value);
	}
	
	public int getGraphMargin() { return graphMargin; }
	public void setGraphMargin(int graphMargin) {
		this.graphMargin = graphMargin;
		repaint();
	}
	
	public int getGraphBarWidth() { return graphBarWidth; }
	public void setGraphBarWidth(int graphBarWidth) { this.graphBarWidth = graphBarWidth; }
	
	private int getYaxisGap(int maxVal) {
		if(maxVal % 10 == 0)
			return maxVal / 10;
		for(int i=0; true; i++)
			if(10*i <= maxVal && maxVal < 10*(i+1))
				return i+1;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		int l1x1 = graphMargin, l1y1 = graphMargin, l1x2 = graphMargin, l1y2 = getSize().height - graphMargin;
		int l2x1 = graphMargin, l2y1 = getSize().height - graphMargin, l2x2 = getSize().width - graphMargin, l2y2 = getSize().height - graphMargin;
		
		int graphWidth = l2x2 - l2x1;
		int graphHeight = l1y2 - l1y1;
		
		int graphContentDeltaX  = graphWidth / contents.size();
		
		Point contentStrStartPoint = new Point(l2x1, l2y1 + 10);
		
		// Base Line Draw
		g2.setColor(Color.BLACK);
		g2.drawLine(l1x1, l1y1, l1x2, l1y2 + 5);
		g2.drawLine(l2x1 - 5, l2y1, l2x2, l2y2);
		
		for(int i=1; i<=contents.size(); i++) // start to 1
			g2.drawLine(l2x1 + graphContentDeltaX * i, getSize().height - graphMargin, l2x1 + graphContentDeltaX * i, getSize().height - graphMargin + 5);
		g2.setColor(Color.BLACK);
		for(int i=5; i>=1; i--) {
			int calY = graphHeight / 5 * (5-i) + graphMargin;
			g2.drawLine(l2x1, calY, l2x2, calY);
		}
		
		// Value Draw
		g2.setColor(Color.ORANGE);
		int maxVal = -1;
		for(int i=0; i<values.size(); i++)
			if(values.get(i) > maxVal)
				maxVal = values.get(i);
		for(int i=0; i<values.size(); i++) {
			int graphBarHeight = (int)((values.get(i) / (float)maxVal) * graphHeight);
			g2.fillRect(contentStrStartPoint.x + ( graphContentDeltaX * i ) + ( graphContentDeltaX / 2 ), getSize().height - graphMargin - graphBarHeight, graphBarWidth, graphBarHeight);
		}
		
		// X Axis Draw
		g2.setColor(Color.BLACK);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setFont(new Font("Consolas", Font.PLAIN, 12)); // or Naver's D2Coding
		
		for(int i=0; i<contents.size(); i++) {
			String strToDraw = contents.get(i);
			if(strToDraw.length() > graphContentDeltaX / 10) // TODO You have to 
				strToDraw = strToDraw.substring(0, graphContentDeltaX / 10) + "..";
			g2.drawString(strToDraw, contentStrStartPoint.x + ( graphContentDeltaX * i ) + ( graphContentDeltaX / 2 ) - ( strToDraw.length() / 2 * 7 ), contentStrStartPoint.y);
		}
		
		// Y Axis Draw
		g2.setColor(Color.BLACK);
		int yAxisGap = getYaxisGap(maxVal);
		for(int i=5; i>=1; i--) {
			int calY = graphHeight / 5 * (5-i) + graphMargin;
			g2.drawLine(graphMargin - 5, calY, graphMargin, calY);
			g2.drawString(String.format("%4d", yAxisGap * 2 * i), graphMargin - 35, calY + 5);
		}
	}
	
}