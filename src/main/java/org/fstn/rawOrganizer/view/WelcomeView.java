package org.fstn.rawOrganizer.view;

import org.fstn.rawOrganizer.controller.WelcomeController;
import org.fstn.rawOrganizer.event.EventType;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Controller;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

@Location(location = Location.CENTER)
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { EventType.RAW_SELECTED, EventType.JPG_SELECTED,
		"RESIZE_TO_768p", "RESIZE_TO_1050p", "RESIZE_TO_1080p" })
@Controller(name = WelcomeController.class)
public class WelcomeView extends FuidViewElement {
	private static final long serialVersionUID = -6106365996406620690L;

	public WelcomeView() {
	}

	public void onResize(final FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub

	}
}