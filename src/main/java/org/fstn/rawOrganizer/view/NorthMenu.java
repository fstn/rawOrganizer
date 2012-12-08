package org.fstn.rawOrganizer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;

import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Top;
import org.fuid.event.FuidEventType;
import org.fuid.view.design.TopElement;

@Location(location = Location.NORTH, index = 1)
@OpenOn(event=FuidEventType.INIT)
@CloseOn(event=FuidEventType.CLOSE)
public class NorthMenu extends JPanel implements TopElement {

	public NorthMenu() {
		this.setPreferredSize(new Dimension(1000,1000));
		JButton jb = new JButton("coucou");
		this.add(jb);
		this.setBackground(Color.GREEN);
		this.setVisible(true);
	}

}
