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
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;
import org.fuid.view.component.ComplexButton;

@Location(location = Location.NORTH)
@Tab(index=1,title="Resize")
@OpenOn(event={FuidEventType.INIT})
@CloseOn(event={FuidEventType.CLOSE})
public class Resize extends JScrollPane implements FuidViewElement{

@InsertContentPanel(layout=FlowLayout.class)
private JPanel content;
	@Construct
	public void init() {
		content.add(new ComplexButton("/small/resolution.png", "1024x768", "RESIZE_TO_768p"));
		content.add(new ComplexButton("/small/resolution.png", "1280x1024", "RESIZE_TO_1024p"));
		content.add(new ComplexButton("/small/resolution.png", "1680x1050", "RESIZE_TO_1050p"));
		content.add(new ComplexButton("/small/resolution.png", "1920x1080", "RESIZE_TO_1080p"));
	}

	public void onResize(FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub
		
	}
}
