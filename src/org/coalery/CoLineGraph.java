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
public class CoLineGraph extends CoFieldGraph {
	public CoLineGraph(String[] contents, CoGraphItem[] values) throws CoGraphInvalidException { super(Arrays.asList(contents), Arrays.asList(values)); }
	public CoLineGraph(List<String> contents, List<CoGraphItem> values) throws CoGraphInvalidException { super(contents, values); }
	
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
		
		if(graphBarOrientation == CoGraphConstant.GRAPH_VERTICAL_BAR) {
			for(int i=0; i<values.size(); i++)
				for(int j=0; j<values.get(i).length(); j++) {
					int x = graphMargin + graphContentDeltaX * i + graphContentDeltaX / 2;
					int y = getSize().height - graphMargin - (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphHeight);
					
					g2.setColor(graphBarColor[j % graphBarColor.length]);
					g2.fillOval(x-3, y-3, 6, 6);
					
					if(i != values.size() - 1) {
						int nx = graphMargin + graphContentDeltaX * (i + 1) + graphContentDeltaX / 2;
						int ny = getSize().height - graphMargin - (int)((values.get(i+1).getValue(j) / (float)(axisGap * 10)) * graphHeight);
						g2.drawLine(x, y, nx, ny);
					}
					
					g2.setColor(Color.BLACK);
					String valueStr = String.valueOf(values.get(i).getValue(j));
					g2.drawString(valueStr, x - valueStr.length() * 3.0f, y - 5);
				}
		} else if(graphBarOrientation == CoGraphConstant.GRAPH_HORIZONTAL_BAR) {
			for(int i=0; i<values.size(); i++)
				for(int j=0; j<values.get(i).length(); j++) {
					int x = graphMargin + (int)((values.get(i).getValue(j) / (float)(axisGap * 10)) * graphWidth);
					int y = graphMargin + graphContentDeltaY * i + graphContentDeltaY / 2;
					
					g2.setColor(graphBarColor[j % graphBarColor.length]);
					g2.fillOval(x-3, y-3, 6, 6);
					
					if(i != values.size() - 1) {
						int nx = graphMargin + (int)((values.get(i+1).getValue(j) / (float)(axisGap * 10)) * graphWidth);
						int ny = graphMargin + graphContentDeltaY * (i + 1) + graphContentDeltaY / 2;
						g2.drawLine(x, y, nx, ny);
					}
					
					g2.setColor(Color.BLACK);
					String valueStr = String.valueOf(values.get(i).getValue(j));
					g2.drawString(valueStr, x - valueStr.length() * 3.0f, y - 5);
				}
		}
	}
}
