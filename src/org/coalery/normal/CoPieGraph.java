package org.coalery.normal;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

import org.coalery.exception.CoGraphInvalidException;

@SuppressWarnings("serial")
public class CoPieGraph extends CoNormalGraph {

	public CoPieGraph(String[] contents, Integer[] values) throws CoGraphInvalidException { super(Arrays.asList(contents), Arrays.asList(values)); }
	public CoPieGraph(List<String> contents, List<Integer> values) throws CoGraphInvalidException { super(contents, values); }

	@Override
	public void paintGraph(Graphics g) {
		
	}
	
}
