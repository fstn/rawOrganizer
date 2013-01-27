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
import org.fuid.event.FuidListener;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;
import org.fuid.view.component.ComplexButton;

@Location(location = Location.NORTH)
@Tab(index = 2, title = "Export")
@OpenOn(event = { FuidEventType.INIT })
@CloseOn(event = { FuidEventType.CLOSE })
public class Export   extends JScrollPane implements FuidViewElement {

@InsertContentPanel(layout=FlowLayout.class)
private JPanel content;
	@Construct
	public void init() {
		content.add(new ComplexButton("/export.png", "Export en JPG", "EXPORT_JPG"));
		content.add(new ComplexButton("/export.png", "Export en PNG", "EXPORT_PNG"));
	}

	public void onResize(FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub
		
	}
}
