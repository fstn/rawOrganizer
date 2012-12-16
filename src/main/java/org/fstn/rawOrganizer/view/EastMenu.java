package org.fstn.rawOrganizer.view;

import java.awt.Color;

import javax.swing.JPanel;

import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.view.design.TopElement;

@Location(location = Location.EAST, index = 1)
@OpenOn(event="INIT")
@CloseOn(event="CLOSE")
public class EastMenu extends JPanel implements TopElement {

	public EastMenu() {
		this.setBackground(Color.BLUE);
		this.setVisible(true);
	}

}
