package org.fstn.rawOrganizer.view;

import java.awt.Color;
import java.awt.Dimension;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.event.EventType;
import org.fuid.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

@Location(location = Location.WEST)
@OpenOn(event={FuidEventType.INIT})
@CloseOn(event={FuidEventType.CLOSE})
public class ImageDetailView extends FuidViewElement implements FuidListener {

	public ImageDetailView() {
		System.out.println("Image viewer up");
		this.setBackground(Color.BLUE);
		this.setVisible(true);
		Session.getInstance().addListener(this);
		this.setPreferredSize(new Dimension(300,300));
	}

	public void onEvent(FuidEvent event) {
		if(event.getType().equals(EventType.FILESELECTED)){
			this.removeAll();
			ImageDTO imageDTO=(ImageDTO)event.getArg();
			PicsThumb picsThumb=new PicsThumb(imageDTO);
			Session.getInstance().getCurrent().put(SessionConstante.SELECTED_FILE, imageDTO);
			imageDTO.getOriginal();
			this.add(picsThumb);
		}
		
	}

	public void clean() {
		Session.getInstance().removeListener(this);
		
	}

	public void onResize(FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub
		
	}

}
