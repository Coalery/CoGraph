package org.coalery;

import java.awt.Graphics;

public interface CoGraph {
	
	String getContentAt(int index);
	void setContentAt(int index, String content);
	
	CoGraphItem getValueAt(int index);
	void setValueAt(int index, CoGraphItem value);
	
	Integer getValueByContentName(String contentName);
	public void setValueByContentName(String contentName, CoGraphItem value);
	
	int getGraphMargin();
	void setGraphMargin(int graphMargin);
	
	void addItem(String contentName, CoGraphItem value);
	
	void paint(Graphics g);
	
}
