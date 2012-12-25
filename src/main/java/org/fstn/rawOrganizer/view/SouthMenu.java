package org.fstn.rawOrganizer.view;

import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEventType;
import org.fuid.view.FuidViewElement;

@Location(location = Location.SOUTH)
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { FuidEventType.CLOSE })
public class SouthMenu extends FuidViewElement {

	public SouthMenu() {
		this.setVisible(true);
	}

}
