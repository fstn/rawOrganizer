package org.fstn.rawOrganizer.view.menu;

import org.fstn.rawOrganizer.view.component.ComplexButton;
import org.fuid.FuidColor;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Tab;
import org.fuid.event.FuidEventType;
import org.fuid.view.FuidViewElement;

@Location(location = Location.NORTH)
@Tab(index = 2, title = "Export")
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { FuidEventType.CLOSE })
public class Export extends FuidViewElement {
	public Export() {
		this.setBackground(FuidColor.BACKGROUND);
		this.add(new ComplexButton("/export.png", "Export en JPG", "EXPORT_JPG"));
		this.add(new ComplexButton("/export.png", "Export en PNG", "EXPORT_PNG"));
	}
}
