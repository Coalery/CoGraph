package org.coalery.field;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.List;

import org.coalery.CoGraphItem;
import org.coalery.exception.CoGraphInvalidException;

@SuppressWarnings("serial")
public class CoStackedBarGraph extends CoFieldGraph {
	private int graphBarSize = 10;
	
	public CoStackedBarGraph(String[] contents, CoGraphItem[] values) throws CoGraphInvalidException { super(Arrays.asList(contents), Arrays.asList(values), true); }
	public CoStackedBarGraph(List<String> contents, List<CoGraphItem> values) throws CoGraphInvalidException { super(contents, values, true); }
	
	public int getGraphBarSize() { return graphBarSize; }
	public void setGraphBarSize(int graphBarSize) {
		this.graphBarSize = graphBarSize;
		repaint();
	}
	
	@Override
	public void paintVerticalGraph(Graphics g, int graphWidth, int graphHeight, int graphContentDeltaX, int axisGap) {
		Graphics2D g2 = (Graphics2D)g;
		for(int i=0; i<values.size(); i++) {
			int sumHeight = 0;
			for(int j=0; j<values.get(i).length(); j++) {
				int graphBarHeight = (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphHeight);
				int x = graphMargin + ( graphContentDeltaX * i ) + ( graphContentDeltaX / 2 ) - (graphBarSize / 2);
				int y = getSize().height - graphMargin - graphBarHeight - sumHeight;
				
				String valueStr = String.valueOf(values.get(i).getValue(j));
				g2.setColor(graphBarColor[j % graphBarColor.length]);
				g2.fillRect(x, y, graphBarSize, graphBarHeight);
				
				if(isValueDraw) {
					g2.setColor(Color.BLACK);
					g2.drawString(valueStr, x + graphBarSize / 2.0f - valueStr.length() * 3.0f, y + 7);
				}
				
				sumHeight += graphBarHeight;
			}
		}
	}
	
	@Override
	public void paintHorizontalGraph(Graphics g, int graphWidth, int graphHeight, int graphContentDeltaY, int axisGap) {
		Graphics2D g2 = (Graphics2D)g;
		for(int i=0; i<values.size(); i++) {
			int sumWidth = 0;
			for(int j=0; j<values.get(i).length(); j++) {
				int graphBarWidth = (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphWidth);
				int x = graphMargin + sumWidth + 1;
				int y = graphMargin + graphContentDeltaY * i + graphContentDeltaY / 2 - (graphBarSize / 2);
				
				String valueStr = String.valueOf(values.get(i).getValue(j));
				g2.setColor(graphBarColor[j % 2]);
				g2.fillRect(x, y, graphBarWidth, graphBarSize);
				
				if(isValueDraw) {
					g2.setColor(Color.BLACK);
					g2.drawString(valueStr, x + graphBarWidth - 13, y + graphBarSize / 2 + 3);
				}
				
				sumWidth += graphBarWidth;
			}
		}
	}
}
