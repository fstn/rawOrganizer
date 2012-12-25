package org.fstn.rawOrganizer.view;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fuid.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

@Location(location = Location.CENTER)
@OpenOn(event = { "RESIZE_TO_768p", "RESIZE_TO_1050p", "RESIZE_TO_1080p" })
@CloseOn(event = { FuidEventType.CLOSE })
public class ResizeView extends FuidViewElement {
	public ResizeView() {
		try {
			ImageInfo info = new ImageInfo();
			ImageDTO imageDTO=(ImageDTO)
					Session.getInstance().getCurrent().get(SessionConstante.SELECTED_FILE);
			
			MagickImage image = new MagickImage(new ImageInfo(imageDTO.getUrl()));
			MagickImage smaller=image.scaleImage(100, 100);
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
}
