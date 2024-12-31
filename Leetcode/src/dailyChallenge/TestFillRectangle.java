package LeetCode;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFillRectangle extends JPanel {

	private int rectX;
	private int rectY;
	private int rectWidth;
	private int rectHeight;

	public TestFillRectangle(int rectX, int rectY, int rectWidth, int rectHeight) {
		this.rectX = rectX;
		this.rectY = rectY;
		this.rectWidth = rectWidth;
		this.rectHeight = rectHeight;
	}

	public void fillRectangle(Graphics g) {
		g.setColor(Color.RED); // Set the fill color (you can change it to any color)
		g.fillRect(rectX, rectY, rectWidth, rectHeight);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		fillRectangle(g);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Fill Rectangle");
		TestFillRectangle testPanel = new TestFillRectangle(50, 50, 100, 80);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(testPanel);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
