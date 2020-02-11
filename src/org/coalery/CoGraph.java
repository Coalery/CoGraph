package org.coalery;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import org.coalery.exception.CoGraphInvalidException;

@SuppressWarnings("serial")
public abstract class CoGraph extends JPanel {
	
	protected List<String> contents;
	protected List<CoGraphItem> values;
	
	protected int graphMargin = 50;
	protected Color[] graphBarColor = {Color.ORANGE, Color.CYAN, Color.MAGENTA};
	protected int graphBarOrientation = 0;
	
	protected boolean isValueDraw = true;
	
	protected String graphFontName = "Consolas";
	
	public boolean isValueDraw() { return isValueDraw; }
	public void setValueDraw(boolean isValueDraw) {
		this.isValueDraw = isValueDraw;
		repaint();
	}
	
	public String getContentAt(int index) { return contents.get(index); }
	public void setContentAt(int index, String content) {
		contents.set(index, content);
		repaint();
	}
	
	public CoGraphItem getValueAt(int index) { return values.get(index); }
	public void setValueAt(int index, CoGraphItem value) {
		values.set(index, value);
		repaint();
	}
	
	public Integer getValueByContentName(String contentName) { return contents.indexOf(contentName); }
	public void setValueByContentName(String contentName, CoGraphItem value) {
		int targetIndex = getValueByContentName(contentName);
		if(targetIndex != -1) setValueAt(targetIndex, value);
		repaint();
	}
	
	public int getGraphMargin() { return graphMargin; }
	public void setGraphMargin(int graphMargin) {
		this.graphMargin = graphMargin;
		repaint();
	}
	
	public void addItem(String contentName, CoGraphItem value) {
		if(values.size() != 0 && values.get(0).length() != value.length()) {
			new CoGraphInvalidException("");
			return;
		}
		contents.add(contentName);
		values.add(value);
		repaint();
	}
	
	protected int getAxisGap() {
		int maxVal = -1;
		for(int i=0; i<values.size(); i++)
			for(int j=0; j<values.get(i).length(); j++)
				if(values.get(i).getValue(j) > maxVal)
					maxVal = values.get(i).getValue(j);
		if(maxVal % 10 == 0)
			return maxVal / 10;
		for(int i=0; true; i++)
			if(10*i <= maxVal && maxVal < 10*(i+1))
				return i+1;
	}
	
	public abstract void paint(Graphics g);
	
}
