package example;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.coalery.CoGraph;
import org.coalery.exception.CoGraphInvalidException;

public class TestMain {
	
	public static void main(String[] args) {
		CoGraph graph = null;
		try {graph = new CoGraph(new String[] {"Apple", "Melon", "Water", "Juice", "WaterMelonnnnn", "Hello", "World", "It", "is", "Coalery"}, new Integer[] {3, 17, 21, 26, 19, 121, 57, 39, 48, 91});} catch (CoGraphInvalidException e) { e.printStackTrace(); }
		
		if(graph == null)
			return;
		
		JFrame frame = new JFrame("CoGraph Test");
		frame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent event) {System.exit(0);}}); // Exit
		
		frame.setSize(1000, 800);
		frame.add(graph);
		
		frame.setVisible(true);
//		frame.setResizable(false);
		
	}
	
}
