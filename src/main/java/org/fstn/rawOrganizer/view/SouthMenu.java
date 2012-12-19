package org.fstn.rawOrganizer.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Top;
import org.fuid.event.FuidEventType;
import org.fuid.view.design.TopElement;

@Location(location = Location.SOUTH)
@OpenOn(event={FuidEventType.INIT})
@CloseOn(event={FuidEventType.CLOSE})
public class SouthMenu extends JPanel implements TopElement {

	public SouthMenu() {
		this.setVisible(true);
	}

}
