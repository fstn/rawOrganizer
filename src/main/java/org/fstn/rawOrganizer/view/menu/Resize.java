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
@Tab(index=1,title="Resize")
@OpenOn(event={FuidEventType.INIT})
@CloseOn(event={FuidEventType.CLOSE})
public class Resize extends FuidViewElement{
	public  Resize(){
		this.setBackground(FuidColor.BACKGROUND);
		this.add(new ComplexButton("/resolution.png", "1024x768", "RESIZE_TO_768p"));
		this.add(new ComplexButton("/resolution.png", "1280x1024", "RESIZE_TO_1024p"));
		this.add(new ComplexButton("/resolution.png", "1680x1050", "RESIZE_TO_1050p"));
		this.add(new ComplexButton("/resolution.png", "1920x1080", "RESIZE_TO_1080p"));
	}
}
