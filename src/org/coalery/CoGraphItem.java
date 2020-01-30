package org.coalery;

import java.util.ArrayList;
import java.util.List;

public class CoGraphItem {
	
	private List<Integer> valueList;
	public CoGraphItem(int... values) {
		valueList = new ArrayList<Integer>();
		for(int i=0; i<values.length; i++)
			valueList.add(values[i]);
	}
	
	public int getValue(int idx) { return valueList.get(idx); }
	public int length() { return valueList.size(); }
	
}
