package org.fstn.rawOrganizer.view.menu;

import org.fuid.FuidColor;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Tab;
import org.fuid.event.FuidEventType;
import org.fuid.view.FuidViewElement;

@Location(location = Location.NORTH)
@Tab(index = 4, title = "CopyRight")
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { FuidEventType.CLOSE })
public class WaterMark extends FuidViewElement {

	public WaterMark() {
		this.setBackground(FuidColor.BACKGROUND);
	}

}
