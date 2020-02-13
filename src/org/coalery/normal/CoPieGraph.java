package org.coalery.normal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.List;

import org.coalery.exception.CoGraphInvalidException;

@SuppressWarnings("serial")
public class CoPieGraph extends CoNormalGraph {

	public CoPieGraph(String[] contents, Integer[] values) throws CoGraphInvalidException { super(Arrays.asList(contents), Arrays.asList(values)); }
	public CoPieGraph(List<String> contents, List<Integer> values) throws CoGraphInvalidException { super(contents, values); }

	@Override
	public void paintGraph(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		int size = Math.min(getSize().width - graphMargin * 2, getSize().height - graphMargin * 2);
		int x = (getSize().width - size) / 2;
		int y = (getSize().height - size) / 2;
		
		int sum = 0;
		for(int i=0; i<values.size(); i++)
			sum += values.get(i).getValue(0);
		
		int angleSum = 0;
		for(int i=0; i<values.size(); i++) {
			int angle = (int)((double)values.get(i).getValue(0) / (double)sum * 360.0);
			g2.setColor(graphColor[i % graphColor.length]);
			if(i == values.size() - 1)
				g2.fillArc(x, y, size, size, angleSum, 360 - angleSum);
			else
				g2.fillArc(x, y, size, size, angleSum, angle);
			angleSum += angle;
			
			if(isValueDraw) {
				g2.setColor(Color.BLACK);
				String valueStr = String.valueOf(values.get(i).getValue(0));
				g2.drawString(valueStr, x + size / 2 - valueStr.length() * 3.5f + ((float)Math.cos((angleSum - angle / 2) / 180.0 * Math.PI) * size / 3), (y + size / 2 + 5) - ((float)Math.sin((angleSum - angle / 2) / 180.0 * Math.PI) * size / 3));
				System.out.println(valueStr);
			}
		}
	}
	
}
