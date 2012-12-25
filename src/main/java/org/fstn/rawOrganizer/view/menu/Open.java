package org.fstn.rawOrganizer.view.menu;

import org.fstn.rawOrganizer.controller.OpenController;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.view.component.ImageButton;
import org.fuid.FuidColor;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Controller;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Tab;
import org.fuid.event.FuidEventType;
import org.fuid.view.FuidViewElement;

@Location(location = Location.NORTH)
@Controller(name = OpenController.class)
@Tab(index = 1, title = "Open")
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { FuidEventType.CLOSE })
public class Open extends FuidViewElement {
	public Open() {
		this.setBackground(FuidColor.BACKGROUND);
		this.add(new ImageButton("/small/raw.png", EventType.RAW_SELECTED));
		this.add(new ImageButton("/small/png.png", EventType.PNG_SELECTED));
		this.add(new ImageButton("/small/jpg.png", EventType.JPG_SELECTED));
	}
}
