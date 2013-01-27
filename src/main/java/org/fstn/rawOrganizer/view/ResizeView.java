package org.fstn.rawOrganizer.view;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.util.SessionConstante;
import org.fuid.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Construct;
import org.fuid.annotation.InsertContentPanel;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

@Location(location = Location.CENTER)
@OpenOn(event = { "RESIZE_TO_768p", "RESIZE_TO_1050p", "RESIZE_TO_1080p" })
@CloseOn(event = { FuidEventType.CLOSE })
public class ResizeView extends JScrollPane implements FuidViewElement, FuidListener {

	@InsertContentPanel(layout = FlowLayout.class)
	private JPanel	content;

	@Construct
	public void init() {
		try {
			ImageInfo info = new ImageInfo();
			ImageDTO imageDTO = (ImageDTO) Session.getInstance().getCurrent().get(SessionConstante.SELECTED_FILE);

			MagickImage image = new MagickImage(new ImageInfo(imageDTO.getUrl()));
			MagickImage smaller = image.scaleImage(100, 100);
			smaller.setFileName("biggerSmall.jpg");
			smaller.writeImage(info);
		} catch (MagickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onResize(final FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub

	}

	public void onEvent(FuidEvent event) {
		// TODO Auto-generated method stub

	}

	public void clean() {
		// TODO Auto-generated method stub

	}
}
