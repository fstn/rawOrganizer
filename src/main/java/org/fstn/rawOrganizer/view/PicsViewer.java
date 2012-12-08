package org.fstn.rawOrganizer.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.event.InitializedEvent;
import org.fstn.rawOrganizer.event.InitializedListener;
import org.fstn.rawOrganizer.event.ViewEvent;
import org.fstn.rawOrganizer.util.Session;

public class PicsViewer extends JScrollPane implements InitializedListener {
	private JPanel content;
	public PicsViewer() {
		Session.getInstance().addInitializedListener(this);
		content=new JPanel();
		content.setBackground(Color.black);
		content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
		content.setPreferredSize(new Dimension(380, 800));
		content.setVisible(true);
		this.getViewport().add(content);

		this.setPreferredSize(new Dimension(400,300));
	}

	@Override
	public void onEvent(InitializedEvent event) {
		List<ImageDTO> listImage = event.getListImages();
		for (ImageDTO imageDTO : listImage) {
			ImageIcon imageMiniature = new ImageIcon(imageDTO.getImage());
			JLabel imageLabel = new JLabel();
			imageLabel.setText(imageDTO.getName());
			imageLabel.setIcon(imageMiniature);
			content.add(imageLabel);
			Session.getInstance().fireEvent(new ViewEvent(ViewEvent.ASK4RELOAD, null));
		}
	}
	@Override
	public void finalize(){
		Session.getInstance().removeInitializedListener(this);
	}

}
