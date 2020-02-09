package org.coalery;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Arrays;
import java.util.List;

import org.coalery.exception.CoGraphInvalidException;

@SuppressWarnings("serial")
public class CoBarGraph extends CoFieldGraph {
	private int graphBarSize = 10;
	
	public CoBarGraph(String[] contents, CoGraphItem[] values) throws CoGraphInvalidException { super(Arrays.asList(contents), Arrays.asList(values)); }
	public CoBarGraph(List<String> contents, List<CoGraphItem> values) throws CoGraphInvalidException { super(contents, values); }
	
	public int getGraphBarSize() { return graphBarSize; }
	public void setGraphBarSize(int graphBarSize) {
		this.graphBarSize = graphBarSize;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(contents.size() == 0)
			return;
		
		Graphics2D g2 = (Graphics2D)g;
		
		int graphWidth = getSize().width - graphMargin * 2;
		int graphHeight = getSize().height - graphMargin * 2;
		
		int graphContentDeltaX  = graphWidth / contents.size();
		int graphContentDeltaY  = graphHeight / contents.size();
		
		int axisGap = getAxisGap();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setFont(new Font("Consolas", Font.PLAIN, 10)); // or Naver's D2Coding
		
		if(graphBarOrientation == CoGraphConstant.GRAPH_VERTICAL_BAR) { // if graph orientation is vertical.
			for(int i=0; i<values.size(); i++)
				for(int j=0; j<values.get(i).length(); j++) {
					int graphBarHeight = (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphHeight);
					int x = graphMargin + ( graphContentDeltaX * i ) + ( graphContentDeltaX / 2 ) - (values.get(i).length() * graphBarSize / 2) + graphBarSize * j;
					int y = getSize().height - graphMargin - graphBarHeight;
					String valueStr = String.valueOf(values.get(i).getValue(j));
					g2.setColor(graphBarColor[j % graphBarColor.length]);
					g2.fillRect(x, y, graphBarSize, graphBarHeight);
					
					g2.setColor(Color.BLACK);
					g2.drawString(valueStr, x + graphBarSize / 2.0f - valueStr.length() * 3.0f, y - 1);
				}
		} else if(graphBarOrientation == CoGraphConstant.GRAPH_HORIZONTAL_BAR) {
			for(int i=0; i<values.size(); i++)
				for(int j=0; j<values.get(i).length(); j++) {
					int graphBarWidth = (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphWidth);
					int x = graphMargin + 1;
					int y = graphMargin + graphContentDeltaY * i + graphContentDeltaY / 2 - (values.get(i).length() * graphBarSize / 2) + graphBarSize * j;
					
					String valueStr = String.valueOf(values.get(i).getValue(j));
					g2.setColor(graphBarColor[j % 2]);
					g2.fillRect(x, y, graphBarWidth, graphBarSize);
					
					g2.setColor(Color.BLACK);
					g2.drawString(valueStr, x + graphBarWidth + 1, y + graphBarSize / 2 + 3);
				}
		}
	}
	
}