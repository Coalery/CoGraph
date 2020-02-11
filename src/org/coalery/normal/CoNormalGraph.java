package org.coalery.normal;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.coalery.CoGraph;
import org.coalery.CoGraphItem;
import org.coalery.exception.CoGraphInvalidException;

@SuppressWarnings("serial")
public abstract class CoNormalGraph extends CoGraph { // TODO Change Class Name.
	
	public CoNormalGraph(List<String> contents, List<Integer> values) throws CoGraphInvalidException {
		if(contents == null || values == null)
			throw new CoGraphInvalidException("Contents List or Values List is null!");
		if(contents.size() != values.size())
			throw new CoGraphInvalidException("Contents List length and Values List length is different!");
		
		this.contents = new ArrayList<String>();
		this.values = new ArrayList<CoGraphItem>();
		
		this.contents.addAll(contents);
		for(int i=0; i<values.size(); i++)
			this.values.add(new CoGraphItem(values.get(i)));
	}

	@Override
	public void addItem(String contentName, CoGraphItem value) {
		if(value.length() != 1) {
			new CoGraphInvalidException("Normal Graph value length must be 1.").printStackTrace();
			return;
		}
		super.addItem(contentName, value);
	}

	@Override
	public void paint(Graphics g) {
		
	}
	
	public abstract void paintGraph(Graphics g);

}
