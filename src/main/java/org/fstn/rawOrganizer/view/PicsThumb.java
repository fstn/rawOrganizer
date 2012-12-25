package org.fstn.rawOrganizer.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.util.Current;
import org.fuid.Session;
import org.fuid.event.FuidEvent;

public class PicsThumb extends JPanel implements MouseListener {
	private ImageDTO imageDTO;

	public PicsThumb(ImageDTO newImageDTO) {
		super();
		this.imageDTO = newImageDTO;
		BufferedImage image = imageDTO.getMiniature();
		
		ImageIcon imageMiniature = new ImageIcon(image);

		JLabel imageLabel = new JLabel();
		imageLabel.setText(newImageDTO.getName());
		imageLabel.setIcon(imageMiniature);
		this.add(imageLabel);
		this.addMouseListener(this);
		this.setBackground(Color.BLACK);

	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {
		this.setBackground(Color.GRAY);

	}

	public void mouseExited(MouseEvent arg0) {
		this.setBackground(Color.BLACK);

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		Session.getInstance().getCurrent()
				.put(Current.SELECTED_IMAGE, imageDTO);
		Session.getInstance().fireEvent(
				new FuidEvent(EventType.FILESELECTED, imageDTO));
	}

}
