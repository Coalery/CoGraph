package org.coalery.field;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.List;

import org.coalery.CoGraphItem;
import org.coalery.exception.CoGraphInvalidException;

@SuppressWarnings("serial")
public class CoLineGraph extends CoFieldGraph {
	public CoLineGraph(String[] contents, CoGraphItem[] values) throws CoGraphInvalidException { super(Arrays.asList(contents), Arrays.asList(values)); }
	public CoLineGraph(List<String> contents, List<CoGraphItem> values) throws CoGraphInvalidException { super(contents, values); }
	
	@Override
	public void paintVerticalGraph(Graphics g, int graphWidth, int graphHeight, int graphContentDeltaX, int axisGap) {
		Graphics2D g2 = (Graphics2D)g;
		for(int i=0; i<values.size(); i++)
			for(int j=0; j<values.get(i).length(); j++) {
				int x = graphMargin + graphContentDeltaX * i + graphContentDeltaX / 2;
				int y = getSize().height - graphMargin - (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphHeight);
				
				g2.setColor(graphColor[j % graphColor.length]);
				g2.fillOval(x-3, y-3, 6, 6);
				
				if(i != values.size() - 1) {
					int nx = graphMargin + graphContentDeltaX * (i + 1) + graphContentDeltaX / 2;
					int ny = getSize().height - graphMargin - (int)((values.get(i+1).getValue(j) / (float)(axisGap * 10)) * graphHeight);
					g2.drawLine(x, y, nx, ny);
				}
				
				if(isValueDraw) {
					g2.setColor(Color.BLACK);
					String valueStr = String.valueOf(values.get(i).getValue(j));
					g2.drawString(valueStr, x - valueStr.length() * 3.0f, y - 5);
				}
			}
	}
	
	@Override
	public void paintHorizontalGraph(Graphics g, int graphWidth, int graphHeight, int graphContentDeltaY, int axisGap) {
		Graphics2D g2 = (Graphics2D)g;
		for(int i=0; i<values.size(); i++)
			for(int j=0; j<values.get(i).length(); j++) {
				int x = graphMargin + (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphWidth);
				int y = graphMargin + graphContentDeltaY * i + graphContentDeltaY / 2;
				
				g2.setColor(graphColor[j % graphColor.length]);
				g2.fillOval(x-3, y-3, 6, 6);
				
				if(i != values.size() - 1) {
					int nx = graphMargin + (int)((values.get(i+1).getValue(j) / (float)(axisGap * 10)) * graphWidth);
					int ny = graphMargin + graphContentDeltaY * (i + 1) + graphContentDeltaY / 2;
					g2.drawLine(x, y, nx, ny);
				}
				
				if(isValueDraw) {
					g2.setColor(Color.BLACK);
					String valueStr = String.valueOf(values.get(i).getValue(j));
					g2.drawString(valueStr, x - valueStr.length() * 3.0f, y - 5);
				}
			}
	}
}
