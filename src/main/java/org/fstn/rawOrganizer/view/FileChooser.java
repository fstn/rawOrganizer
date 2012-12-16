package org.fstn.rawOrganizer.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import org.fstn.rawOrganizer.event.EventType;
import org.fuid.Session;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;

public class FileChooser extends JPanel {
	private JPanel element;

	public FileChooser() {
		super();
		element = this;
		this.setBackground(Color.gray);

		JButton browse = new JButton("Parcourir");
		this.add(browse);
		browse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser jfChooser = new JFileChooser();
				jfChooser.setVisible(true);
				jfChooser.setCurrentDirectory(new File(
						"/media/fstn/9C60CF5C60CF3BB0/a trier"));
				jfChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = jfChooser.showOpenDialog(element.getParent());

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					Session.getInstance().fireEvent(
							new FuidEvent(EventType.FILECHOOSE, jfChooser
									.getSelectedFile()));
					Session.getInstance().fireEvent(
							new FuidEvent(FuidEventType.REPACK,null));
				}
			}
		});
	}


}
