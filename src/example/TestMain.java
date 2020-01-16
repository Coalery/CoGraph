package example;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.coalery.CoGraph;

public class TestMain {
	
	public static void main(String[] args) {
		CoGraph graph = new CoGraph(new String[] {"Apple", "Melon", "Water", "Juice", "WaterMelon"}, new Integer[] {1, 2, 4, 5, 10});
		graph.getValueByContentName("");
		
		JFrame frame = new JFrame("CoGraph Test");
		frame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent event) {System.exit(0);}}); // Exit
		
		frame.setSize(400, 300);
		frame.add(graph);
		
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
}
