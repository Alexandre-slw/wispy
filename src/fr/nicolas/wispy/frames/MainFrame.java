package fr.nicolas.wispy.frames;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import fr.nicolas.wispy.panels.GamePanel;
import fr.nicolas.wispy.panels.MenuPanel;
import fr.nicolas.wispy.panels.components.menu.WPanel;

public class MainFrame extends JFrame {

	private WPanel panel;
	public static final int INIT_WIDTH = 1250, INIT_HEIGHT = 720;

	public MainFrame() {
		this.setTitle("Wispy");
		this.setSize(INIT_WIDTH, INIT_HEIGHT);
		this.setMinimumSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new MenuPanel(this.getBounds(), this);

		this.addComponentListener(new ComponentListener() {
			public void componentResized(ComponentEvent e) {
				panel.setFrameBounds(getBounds());
			}

			public void componentHidden(ComponentEvent e) {
			}

			public void componentMoved(ComponentEvent e) {
			}

			public void componentShown(ComponentEvent e) {
			}
		});

		this.setContentPane(panel);

		this.setVisible(true);
	}

	public void newGame() {
		panel = new GamePanel(this.getBounds(), true);
		this.setContentPane(panel);
		this.validate();
		panel.requestFocus();
	}

}
