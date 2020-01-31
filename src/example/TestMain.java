package example;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.coalery.CoBarGraph;
import org.coalery.CoGraphItem;
import org.coalery.exception.CoGraphInvalidException;

public class TestMain {
	
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
		
		CoBarGraph graph0 = new CoBarGraph(contents, values0);
		CoBarGraph graph1 = new CoBarGraph(contents, values1);
		CoBarGraph graph2 = new CoBarGraph(contents, values2);
		
		JFrame frame = new JFrame("CoGraph Test");
		frame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent event) {System.exit(0);}}); // Exit
		frame.setLayout(new GridLayout(3, 1));
		
		frame.setSize(600, 900);
		frame.add(graph0);
		frame.add(graph1);
		frame.add(graph2);
		
		frame.setVisible(true);
//		frame.setResizable(false);
		
	}
	
}
