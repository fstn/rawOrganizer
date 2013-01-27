package org.fstn.rawOrganizer.view.menu;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fstn.rawOrganizer.controller.OpenController;
import org.fstn.rawOrganizer.event.EventType;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Construct;
import org.fuid.annotation.Controller;
import org.fuid.annotation.InsertContentPanel;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Tab;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;
import org.fuid.view.component.ImageButton;

@Location(location = Location.NORTH)
@Controller(name = OpenController.class)
@Tab(index = 1, title = "Open")
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { FuidEventType.CLOSE })
public class Open extends JScrollPane implements FuidViewElement {
	
@InsertContentPanel(layout=FlowLayout.class)
private JPanel content;
	@Construct
	public void init() {
		content.add(new ImageButton("/small/jpg.png", EventType.JPG_SELECTED));
		content.add(new ImageButton("/small/raw.png", EventType.RAW_SELECTED));
		content.add(new ImageButton("/small/png.png", EventType.PNG_SELECTED));
	}

	public void onResize(FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub

	}
}
