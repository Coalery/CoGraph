package org.coalery;

import java.util.List;

public class CoGraphValueItem {
	
	private List<Integer> valueList;
	public CoGraphValueItem(int... values) {
		for(int i=0; i<values.length; i++)
			valueList.add(values[i]);
	}
	
	public int getValue(int idx) { return valueList.get(idx); }
	
}
