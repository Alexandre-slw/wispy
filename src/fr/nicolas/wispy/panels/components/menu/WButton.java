package fr.nicolas.wispy.panels.components.menu;

import fr.nicolas.wispy.game.utils.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class WButton extends JPanel {
	private BufferedImage icon, iconHovered;
	private Rectangle button;
	private boolean isHovered = false;
	private String text;
	private int size = 40;

	public WButton(String text, Rectangle bounds) {
		this.text = text;
		button = bounds;
		loadImages("default");
	}

	public WButton(String text, String iconName, Rectangle bounds) {
		button = bounds;
		loadImages(iconName);
	}

	private void loadImages(String iconName) {
		icon = Assets.get("buttons/" + iconName);
		iconHovered = Assets.get("buttons/" + iconName + "_hover");
	}

	public boolean mouseClick(Point mouseLocation) {
        return button.contains(mouseLocation);
	}

	public boolean mouseClick(Point mouseLocation, boolean isRightClick) {
		if (isRightClick) {
			if (button.contains(mouseLocation)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void mouseMove(Point mouseLocation) {
		if (button.contains(mouseLocation)) {
			isHovered = true;
		} else {
			isHovered = false;
		}
	}

	public void setHovered(boolean isHovered) {
		this.isHovered = isHovered;
	}

	public void changeBounds(Rectangle bounds) {
		button = bounds;
		this.setBounds(bounds);
	}
	
	public void reSize(int newSize) {
		this.size = newSize;
	}

	public void paintComponent(Graphics g) {
		if (isHovered) {
			g.drawImage(iconHovered, 0, 0, this.getWidth(), this.getHeight(), null);
		} else {
			g.drawImage(icon, 0, 0, this.getWidth(), this.getHeight(), null);
		}
		
		g.setColor(new Color(255, 255, 255, 180));
		g.setFont(new Font("Arial", Font.PLAIN, size));
		g.drawString(text, this.getWidth() / 2 - g.getFontMetrics().stringWidth(text)/2, this.getHeight() / 2 +2*size/6);
	}
}
