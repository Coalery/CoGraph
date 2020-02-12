package org.coalery.normal;

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
		System.out.println(values.size());
		for(int i=0; i<values.size(); i++) {
			int angle = (int)((float)values.get(i).getValue(0) / (float)sum * 360.0f);
			g2.setColor(graphColor[i % graphColor.length]);
			g2.fillArc(x, y, size, size, angleSum, angle);
			System.out.println(angleSum + ", " + angle);
			angleSum += angle;
		}
	}
	
}
