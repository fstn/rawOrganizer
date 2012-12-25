package org.fstn.rawOrganizer.view;

import java.awt.Color;

import org.fstn.rawOrganizer.view.component.ImageButton;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

@Location(location = Location.NORTH)
@OpenOn(event={FuidEventType.INIT})
@CloseOn(event={FuidEventType.CLOSE})
public class NorthMenu extends FuidViewElement {

	public NorthMenu() {
		this.add(new ImageButton("/back.png", FuidEventType.INIT));
		this.add(new ImageButton("/quit.png", FuidEventType.CLOSE));
		this.setVisible(true);
		this.setBackground(Color.BLACK);
	}

	public void onResize(FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub
		
	}

}
