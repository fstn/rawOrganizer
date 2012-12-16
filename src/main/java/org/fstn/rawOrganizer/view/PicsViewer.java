package org.fstn.rawOrganizer.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fstn.rawOrganizer.controller.PicsViewerController;
import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.event.EventType;
import org.fuid.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Controller;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;

@Location(location = Location.SOUTH, index = 1)
@OpenOn(event = FuidEventType.INIT)
@CloseOn(event = FuidEventType.CLOSE)
@Controller(name = PicsViewerController.class)
public class PicsViewer extends JScrollPane implements FuidListener {
	private JPanel content;

	public PicsViewer() {
		Session.getInstance().addListener(this);
		content = new JPanel();
		content.setBackground(Color.black);
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.setPreferredSize(new Dimension(380, 800));
		content.setVisible(true);
		this.getViewport().add(content);

		this.setPreferredSize(new Dimension(400, 300));
	}

	public void clean() {
		Session.getInstance().removeListener(this);
	}

	public void onEvent(FuidEvent event) {

		if (event.getType() == EventType.SHOWFILES) {
			List<ImageDTO> listImage = (List<ImageDTO>) event.getArg();
			for (ImageDTO imageDTO : listImage) {
				ImageIcon imageMiniature = new ImageIcon(imageDTO.getImage());
				JLabel imageLabel = new JLabel();
				imageLabel.setText(imageDTO.getName());
				imageLabel.setIcon(imageMiniature);
				content.add(imageLabel);
			}

		}
	}
}
