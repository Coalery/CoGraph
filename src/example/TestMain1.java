package example;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.coalery.CoBarGraph;
import org.coalery.CoGraphConstant;
import org.coalery.CoGraphItem;
import org.coalery.CoLineGraph;
import org.coalery.CoStackedBarGraph;
import org.coalery.exception.CoGraphInvalidException;

public class TestMain1 {
	
	public static void main(String[] args) throws CoGraphInvalidException {
		ArrayList<String> contents = new ArrayList<String>();
		contents.add("Apple");
		contents.add("Melon");
		contents.add("Water");
		contents.add("Juice");
		contents.add("Coalery");
		
		ArrayList<CoGraphItem> values0 = new ArrayList<CoGraphItem>();
		values0.add(new CoGraphItem(47, 35, 12));
		values0.add(new CoGraphItem(45, 92, 23));
		values0.add(new CoGraphItem(33, 39, 76));
		values0.add(new CoGraphItem(29, 43, 54));
		values0.add(new CoGraphItem(34, 31, 43));
		
		ArrayList<CoGraphItem> values1 = new ArrayList<CoGraphItem>();
		values1.add(new CoGraphItem(73, 34));
		values1.add(new CoGraphItem(17, 57));
		values1.add(new CoGraphItem(21, 39));
		values1.add(new CoGraphItem(26, 48));
		values1.add(new CoGraphItem(19, 91));
		
		ArrayList<CoGraphItem> values2 = new ArrayList<CoGraphItem>();
		values2.add(new CoGraphItem(42));
		values2.add(new CoGraphItem(31));
		values2.add(new CoGraphItem(92));
		values2.add(new CoGraphItem(73));
		values2.add(new CoGraphItem(15));
		
		CoBarGraph bgraph0 = new CoBarGraph(contents, values0);
		CoBarGraph bgraph1 = new CoBarGraph(contents, values1);
		CoBarGraph bgraph2 = new CoBarGraph(contents, values2);
		CoBarGraph bgraph3 = new CoBarGraph(new String[] {}, new CoGraphItem[] {});
		
		CoLineGraph lgraph0 = new CoLineGraph(contents, values0);
		CoLineGraph lgraph1 = new CoLineGraph(contents, values1);
		CoLineGraph lgraph2 = new CoLineGraph(contents, values2);
		CoLineGraph lgraph3 = new CoLineGraph(new String[] {}, new CoGraphItem[] {});
		
		CoStackedBarGraph sbgraph0 = new CoStackedBarGraph(contents, values0);
		CoStackedBarGraph sbgraph1 = new CoStackedBarGraph(contents, values1);
		CoStackedBarGraph sbgraph2 = new CoStackedBarGraph(contents, values2);
		CoStackedBarGraph sbgraph3 = new CoStackedBarGraph(new String[] {}, new CoGraphItem[] {});
		
		bgraph1.setGraphBarSize(5);
		bgraph1.setOrientation(CoGraphConstant.GRAPH_HORIZONTAL_BAR);
		
		bgraph2.setValueDraw(false);
		
		bgraph3.addItem("Hello1", new CoGraphItem(5, 3));
		bgraph3.addItem("Hello2", new CoGraphItem(7, 1));
		bgraph3.addItem("Hello3", new CoGraphItem(6, 9));
		bgraph3.addItem("Hello4", new CoGraphItem(3, 2));
		
		lgraph1.setOrientation(CoGraphConstant.GRAPH_HORIZONTAL_BAR);
		
		lgraph2.setValueDraw(false);
		
		lgraph3.addItem("Hello1", new CoGraphItem(5, 3));
		lgraph3.addItem("Hello2", new CoGraphItem(7, 1));
		lgraph3.addItem("Hello3", new CoGraphItem(6, 9));
		lgraph3.addItem("Hello4", new CoGraphItem(3, 2));
		
		sbgraph1.setGraphBarSize(5);
		sbgraph1.setOrientation(CoGraphConstant.GRAPH_HORIZONTAL_BAR);
		
		sbgraph2.setValueDraw(false);
		
		sbgraph3.addItem("Hello1", new CoGraphItem(5, 3));
		sbgraph3.addItem("Hello2", new CoGraphItem(7, 1));
		sbgraph3.addItem("Hello3", new CoGraphItem(6, 9));
		sbgraph3.addItem("Hello4", new CoGraphItem(3, 2));
		
		JFrame frame = new JFrame("CoGraph Test");
		frame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent event) {System.exit(0);}}); // Exit
		frame.setLayout(new GridLayout(4, 3));
		
		frame.setSize(1800, 900);
		
		frame.add(bgraph0); frame.add(lgraph0); frame.add(sbgraph0);
		frame.add(bgraph1); frame.add(lgraph1); frame.add(sbgraph1);
		frame.add(bgraph2); frame.add(lgraph2); frame.add(sbgraph2);
		frame.add(bgraph3); frame.add(lgraph3); frame.add(sbgraph3);
		
		frame.setVisible(true);
	}
	
}
