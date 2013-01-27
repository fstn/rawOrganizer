package org.fstn.rawOrganizer.view.menu;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fuid.FuidColor;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Construct;
import org.fuid.annotation.InsertContentPanel;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Tab;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

@Location(location = Location.NORTH)
@Tab(index = 4, title = "CopyRight")
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { FuidEventType.CLOSE })
public class WaterMark extends JScrollPane implements FuidViewElement,FuidListener {

@InsertContentPanel(layout=FlowLayout.class)
private JPanel content;
	@Construct
	public void init() {
	}

	public void onEvent(FuidEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void clean() {
		// TODO Auto-generated method stub
		
	}

	public void onResize(FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub
		
	}

}
