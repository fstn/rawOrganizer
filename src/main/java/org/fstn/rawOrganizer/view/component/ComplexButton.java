package org.fstn.rawOrganizer.view.component;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.fstn.rawOrganizer.controller.viewer.PicsViewerController;
import org.fstn.rawOrganizer.event.EventType;
import org.fuid.Session;
import org.fuid.event.FuidEvent;

public class ComplexButton extends JPanel  {

	Logger logger=Logger.getLogger(ComplexButton.class.getCanonicalName());
	private String text;
	public ComplexButton(final String newImage,final String newText,final String  eventToFire) {
		final JPanel content=this;
		JLabel imageLabel = new JLabel();
		this.text=newText;
		ImageIcon imageIcon=createImageIcon(newImage);
		imageLabel.setIcon(imageIcon);
		
		imageLabel.setText(newText);
		this.add(imageLabel);
		content.setBackground(Color.BLACK);
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				Session.getInstance().fireEvent(new FuidEvent(eventToFire, null));
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				content.setBackground(Color.BLACK);
				
			}
			
			public void mouseEntered(MouseEvent e) {
				content.setBackground(Color.GRAY);
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	protected ImageIcon createImageIcon(String path) {
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			logger.warning("Couldn't load image file: " + path);
			return null;
		}

	}

}
