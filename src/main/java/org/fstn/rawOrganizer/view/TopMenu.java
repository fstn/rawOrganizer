package org.fstn.rawOrganizer.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class TopMenu extends JMenuBar {

	private JMenuBar menuBar;

	public TopMenu() {
		//Create the menu bar.
		JMenu fichier = new JMenu("Fichier");
		this.add(fichier);
		JMenu analyse = new JMenu("Analyser un r�pertoire");
		fichier.add(analyse);
	}

}
