package org.coalery;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import org.coalery.exception.ValueNotFoundException;

@SuppressWarnings("serial")
public class CoGraph extends JPanel {
	
	private List<String> contents; // or item? ( variable name )
	private List<Integer> values;
	
	public CoGraph(String[] contents, Integer[] values) {
		this(Arrays.asList(contents), Arrays.asList(values));
	}
	
	public CoGraph(List<String> contents, List<Integer> values) {
		this.contents = contents;
		this.values = values;
	}
	
	public List<String> getContents() { return contents; }
	public List<Integer> getValues() { return values; }
	
	public String getContentAt(int index) { return contents.get(index); }
	public Integer getValueAt(int index) { return values.get(index); }
	
	public Integer getValueByContentName(String contentName) throws ValueNotFoundException {
		int index = contents.indexOf(contentName);
		if(index == -1)
			throw new ValueNotFoundException(contentName);
		return values.get(index);
	}
	
}